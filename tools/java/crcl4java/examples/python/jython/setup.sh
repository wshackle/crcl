#!/bin/bash

set -x;

\rm -f setup.ok

sudo -n apt-get install jython || (echo "apt-get install jython Failed. Please run sudo setup.sh or manually run each command in setup.sh as root." ; exit 1) || exit 1;


touch setup.ok
