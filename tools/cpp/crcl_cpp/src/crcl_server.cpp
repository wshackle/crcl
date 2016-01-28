#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/wait.h>

#include <crcl_cpp/CRCLCommandInstanceClasses.hh>
#include <crcl_cpp/CRCLCommandsClasses.hh>
#include <crcl_cpp/crcl_server.h>

// globals used by the parser
extern CRCLCommandInstanceFile *CRCLCommandInstanceTree;
extern int yyparse();
extern void yylex_destroy();
extern char *yyStringInputPointer;
extern char *yyStringInputEnd;

static int socket_get_server_id_on_interface(int port, const char *intf)
{
  int socket_fd;
  struct sockaddr_in myaddr;
  int on;
  struct linger mylinger = { 0 };
  enum {BACKLOG = 5};

  if (-1 == (socket_fd = socket(PF_INET, SOCK_STREAM, 0))) {
    perror("socket");
    return -1;
  }

  /*
    Turn off bind address checking, and allow
    port numbers to be reused - otherwise the
    TIME_WAIT phenomenon will prevent binding
    to these address.port combinations for
    (2 * MSL) seconds.
  */
  on = 1;
  if (-1 == 
      setsockopt(socket_fd,
		 SOL_SOCKET,
		 SO_REUSEADDR,
		 (const char *) &on,
		 sizeof(on))) {
    perror("setsockopt");
    close(socket_fd);
    return -1;
  }

  /*
    When connection is closed, there is a need
    to linger to ensure all data is transmitted.
  */
  mylinger.l_onoff = 1;
  mylinger.l_linger = 30;
  if (-1 ==
      setsockopt(socket_fd,
		 SOL_SOCKET,
		 SO_LINGER,
		 (const char *) &mylinger,
		 sizeof(struct linger))) {
    perror("setsockopt");
    close(socket_fd);
    return -1;
  }

  memset(&myaddr, 0, sizeof(struct sockaddr_in));
  myaddr.sin_family = PF_INET;
  if (NULL == intf) {
    myaddr.sin_addr.s_addr = htonl(INADDR_ANY);
  } else {
    myaddr.sin_addr.s_addr = inet_addr(intf);
  }
  myaddr.sin_port = htons(port);

  if (-1 == bind(socket_fd, (struct sockaddr *) &myaddr,
		 sizeof(struct sockaddr_in))) {
    perror("bind");
    close(socket_fd);
    return -1;
  }

  if (-1 == listen(socket_fd, BACKLOG)) {
    perror("listen");
    close(socket_fd);
    return -1;
  }

  return socket_fd;
}

static int socket_get_connection_id(int socket_fd)
{
  fd_set rfds;
  struct sockaddr_in client_addr;
  struct sockaddr client_info;
  unsigned int client_len;
  int client_fd;
  int retval;

  do {
    FD_ZERO(&rfds);
    FD_SET(socket_fd, &rfds);
    retval = select(socket_fd + 1, &rfds, NULL, NULL, NULL);
  } while (0 == retval ||
	   ! FD_ISSET(socket_fd, &rfds));

  if (retval == -1) {
    perror("select");
    return -1;
  }

  memset(&client_addr, 0, sizeof(struct sockaddr_in));
  client_len = sizeof(struct sockaddr_in);
  client_fd = 
    accept(socket_fd,
	   (struct sockaddr *) &client_addr, 
	   &client_len);
  if (-1 == client_fd) {
    perror("accept");
    return -1;
  }
  
  return client_fd;
}

int CRCLServer::init(int _port)
{
  int _fd;

  port = _port;
  _fd = socket_get_server_id_on_interface(_port, NULL);
  if (_fd < 0) return -1;
  server_fd = _fd;

  return 0;
}

int CRCLServer::getConnection(void)
{
  int _fd;

  _fd = socket_get_connection_id(server_fd);
  if (_fd < 0) return -1;
  client_fd = _fd;

  return 0;
}

CRCLCommandType *CRCLServer::getCommand(void)
{
  enum {BUFFERLEN = 1024};
  char inbuf[BUFFERLEN];
  int nchars;
  pid_t pid;
  int status;
  
  nchars = recv(client_fd, inbuf, sizeof(inbuf) - 1, 0);
  if (nchars <= 0 || nchars >= sizeof(inbuf)) return NULL;
  inbuf[nchars] = 0;

  yyStringInputPointer = inbuf;
  yyStringInputEnd = inbuf + nchars;

  // yyparse() calls exit() directly upon error, so we'll test it first

  pid = fork();
  if (0 == pid) {
    // try it in this child process first
    yyparse();
    // if we got here, it worked, so exit with a 0 status
    exit(0);
  }
  // else we're the parent, so check the child's exit code
  waitpid(pid, &status, 0);
  if (0 == WEXITSTATUS(status)) {
    // it worked, so do it again here
    yyparse();
    yylex_destroy();
    return CRCLCommandInstanceTree->CRCLCommandInstance->CRCLCommand;
  } else {
    // it didn't work
    return NULL;
  }

  return NULL;
}

void CRCLServer::quit(void)
{
  if (-1 != client_fd) close(client_fd);
  if (-1 != server_fd) close(server_fd);

  port = -1;
  server_fd = -1;
  client_fd = -1;

  return;
}

void CRCLServer::debug(bool b)
{
  do_debug = b;
}

