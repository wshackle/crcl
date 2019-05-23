/*
 * This software is public domain software, however it is preferred
 * that the following disclaimers be attached.
 * Software Copywrite/Warranty Disclaimer
 * 
 * This software was developed at the National Institute of Standards and
 * Technology by employees of the Federal Government in the course of their
 * official duties. Pursuant to title 17 Section 105 of the United States
 * Code this software is not subject to copyright protection and is in the
 * public domain.
 * 
 * This software is experimental. NIST assumes no responsibility whatsoever 
 * for its use by other parties, and makes no guarantees, expressed or 
 * implied, about its quality, reliability, or any other characteristic. 
 * We would appreciate acknowledgement if the software is used. 
 * This software can be redistributed and/or modified freely provided 
 * that any derivative works bear some notice that they are derived from it, 
 * and any modified versions bear some notice that they have been modified.
 * 
 *  See http://www.copyright.gov/title17/92chap1.html#105
 * 


 */
package com.github.wshackle.crcl4java.motoman.ui;

import com.github.wshackle.crcl4java.motoman.MotoPlusConnection;
import com.github.wshackle.crcl4java.motoman.MotomanCrclServer;
import crcl.ui.misc.ObjTableJPanel;
import crcl.utils.CRCLServerSocket;
import crcl.utils.CRCLSocket;
import crcl.utils.PropertiesUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
public class MotomanCrclServerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MotomanCrclServerJPanel
     */
    public MotomanCrclServerJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelTelnet = new javax.swing.JPanel();
        telnetJPanel1 = new com.github.wshackle.crcl4java.motoman.ui.TelnetJPanel();
        jPanelMotoPlusCrclCommunications = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCrclPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMotoplusHost = new javax.swing.JTextField();
        jCheckBoxConnect = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMotoplusPort = new javax.swing.JTextField();
        jCheckBoxDebug = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaErrLog = new javax.swing.JTextArea();
        jButtonSendRequest = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        jPanelTelnet.setBorder(javax.swing.BorderFactory.createTitledBorder("Telnet"));

        javax.swing.GroupLayout jPanelTelnetLayout = new javax.swing.GroupLayout(jPanelTelnet);
        jPanelTelnet.setLayout(jPanelTelnetLayout);
        jPanelTelnetLayout.setHorizontalGroup(
            jPanelTelnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelnetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(telnetJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTelnetLayout.setVerticalGroup(
            jPanelTelnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelnetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(telnetJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telnet FS100 Debugging", jPanelTelnet);

        jLabel1.setText("CRCL Port:");

        jTextFieldCrclPort.setText("64444");

        jLabel2.setText("Motoman Motoplus TCP Host:");

        jTextFieldMotoplusHost.setText(MotoPlusConnection.getDefaultHost());

        jCheckBoxConnect.setText("Connected");
        jCheckBoxConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxConnectActionPerformed(evt);
            }
        });

        jLabel3.setText("Port:");

        jTextFieldMotoplusPort.setText("12222  ");

        jCheckBoxDebug.setText("Debug");
        jCheckBoxDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDebugActionPerformed(evt);
            }
        });

        jTextAreaErrLog.setColumns(20);
        jTextAreaErrLog.setRows(5);
        jScrollPane1.setViewportView(jTextAreaErrLog);

        jButtonSendRequest.setText("Send Request");
        jButtonSendRequest.setEnabled(false);
        jButtonSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendRequestActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Networked ATI Force Sensor");

        javax.swing.GroupLayout jPanelMotoPlusCrclCommunicationsLayout = new javax.swing.GroupLayout(jPanelMotoPlusCrclCommunications);
        jPanelMotoPlusCrclCommunications.setLayout(jPanelMotoPlusCrclCommunicationsLayout);
        jPanelMotoPlusCrclCommunicationsLayout.setHorizontalGroup(
            jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                .addComponent(jCheckBoxDebug)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                        .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldCrclPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxConnect))
                            .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldMotoplusHost, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMotoplusPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSendRequest)))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanelMotoPlusCrclCommunicationsLayout.setVerticalGroup(
            jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createSequentialGroup()
                .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCrclPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxConnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelMotoPlusCrclCommunicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldMotoplusHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSendRequest)
                        .addComponent(jTextFieldMotoplusPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDebug)
                .addContainerGap())
        );

        jTabbedPane1.addTab("MotoPlus / CRCL Communications", jPanelMotoPlusCrclCommunications);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private MotomanCrclServer motomanCrclServer = null;
    private int motomanPort = MotomanCrclServer.DEFAULT_MOTOMAN_PORT;
    private int crclPort = CRCLSocket.DEFAULT_PORT;
    private String motomanHost = MotomanCrclServer.DEFAULT_MOTOMAN_HOST;
    private Thread crclThread = null;

    private int connectTimeoutMillis = 2000;

    /**
     * Get the value of connectTimeoutMillis
     *
     * @return the value of connectTimeoutMillis
     */
    public int getConnectTimeoutMillis() {
        return connectTimeoutMillis;
    }

    /**
     * Set the value of connectTimeoutMillis
     *
     * @param connectTimeoutMillis new value of connectTimeoutMillis
     */
    public void setConnectTimeoutMillis(int connectTimeoutMillis) {
        this.connectTimeoutMillis = connectTimeoutMillis;
    }

    private Socket createSocketWithTimeout(String host, int port, int timeoutMillis) throws IOException {
        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);
        logPrintln("inetSocketAddress = " + inetSocketAddress + ", timoutMillis=" + timeoutMillis);
        socket.connect(inetSocketAddress, timeoutMillis);
        logPrintln("socket.connect() done.");
        return socket;
    }

    public boolean isCrclMotoplusConnected() {
        return jCheckBoxConnect.isSelected()
                && null != motomanCrclServer
                && null != crclThread
                && crclThread.isAlive()
                && motomanCrclServer.mpcConnected();
    }

    private final int LOG_SIZE_LIMIT = 5000;

    private void appendLog(String s) {
        jTextAreaErrLog.append(s + '\n');
        String fullString = jTextAreaErrLog.getText();
        if (fullString.length() > LOG_SIZE_LIMIT) {
            int index = Math.max(LOG_SIZE_LIMIT, fullString.indexOf('\n', LOG_SIZE_LIMIT));
            jTextAreaErrLog.setText(fullString.substring(index));
        }
    }

    private void logPrintln(String s) {
        System.out.println(s);
        appendLog(s);
    }

    private void errLogPrintln(String s) {
        System.err.println(s);
        appendLog(s);
    }

    private final Consumer<String> logConsumer = this::appendLog;

    public void connectCrclMotoplus() throws IOException {
        internalDisconnect();
        motomanCrclServer = new MotomanCrclServer(
                new CRCLServerSocket(crclPort),
                new MotoPlusConnection(createSocketWithTimeout(motomanHost, motomanPort, connectTimeoutMillis)));
        motomanCrclServer.setDebug(jCheckBoxDebug.isSelected());
        motomanCrclServer.addLogListener(logConsumer);
        crclThread = new Thread(motomanCrclServer, "motomanCrclServer");
        crclThread.start();
        if (!jCheckBoxConnect.isSelected()) {
            jCheckBoxConnect.setSelected(true);
        }
        jButtonSendRequest.setEnabled(true);
    }

    public void disconnectCrclMotoplus() {
        if (jCheckBoxConnect.isSelected()) {
            jCheckBoxConnect.setSelected(false);
        }
        internalDisconnect();
        jButtonSendRequest.setEnabled(false);
    }

    private void internalDisconnect() {
        if (null != motomanCrclServer) {
            motomanCrclServer.removeLogListener(logConsumer);
            try {
                motomanCrclServer.close();
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
            motomanCrclServer = null;
        }
        if (null != crclThread) {
            if (crclThread.isAlive()) {
                errLogPrintln("Interrupting Motoman CRCL server thread");
                try {
                    crclThread.join(100);
                } catch (InterruptedException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
                if (crclThread.isAlive()) {
                    crclThread.interrupt();
                    try {
                        crclThread.join(100);
                    } catch (InterruptedException ex) {
                        LOGGER.log(Level.SEVERE, null, ex);
                    }
                }
            }
            crclThread = null;
        }
    }
    private void jCheckBoxConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxConnectActionPerformed

        updateConnection();
    }//GEN-LAST:event_jCheckBoxConnectActionPerformed

    private void jCheckBoxDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDebugActionPerformed
        if (null != motomanCrclServer) {
            motomanCrclServer.setDebug(jCheckBoxDebug.isSelected());
        }
    }//GEN-LAST:event_jCheckBoxDebugActionPerformed

    private void jButtonSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendRequestActionPerformed

        if (null != motomanCrclServer) {
            try {
                MotoPlusConnection mpc = motomanCrclServer.getMpc();
                Method mpcMethods[] = mpc.getClass().getDeclaredMethods();
                HashMap<String, Method> methodMap = new HashMap<>();
                for (int i = 0; i < mpcMethods.length; i++) {
                    Method mpcMethod = mpcMethods[i];
                    if (Modifier.isPublic(mpcMethod.getModifiers())) {
                        methodMap.put(mpcMethod.getName(), mpcMethod);
                    }
                }
                String methodNames[] = methodMap.keySet().toArray(new String[0]);
                Arrays.sort(methodNames, 0, methodNames.length);
                String selectedMethodName = (String) JOptionPane.showInputDialog(this, "Mpc Method", "Send Request", JOptionPane.QUESTION_MESSAGE, null, methodNames, null);
                logPrintln("selectedMethodName = " + selectedMethodName);
                if (null == selectedMethodName || selectedMethodName.length() < 1) {
                    // User probably cancelled.
                    return;
                }
                Method selectedMethod = methodMap.get(selectedMethodName);
                logPrintln("selectedMethod = " + selectedMethod);
                Object objectParams[] = new Object[selectedMethod.getParameterCount()];
                JFrame parentJFrame = (JFrame) getParent().getParent().getParent().getParent();
                Map<String, Object> argsMap = new TreeMap<>();
                for (int i = 0; i < objectParams.length; i++) {
                    Class<?> parameterType = selectedMethod.getParameterTypes()[i];
//                    logPrintln("parameterType = " + parameterType);
                    String paramName = selectedMethod.getParameters()[i].getName();
//                    logPrintln("paramName = " + paramName);

                    String queryString = selectedMethodName + " (parameter " + i + ") " + paramName;
                    Object objectParam;
                    if (parameterType.isArray()) {
                        int arrayLength = Integer.parseInt(JOptionPane.showInputDialog(parentJFrame, "Length of " + queryString, 1));
                        Class<?> compenentType = parameterType.getComponentType();
                        if (compenentType.isPrimitive()) {
                            if (compenentType == byte.class) {
                                byte newArray[] = new byte[arrayLength];
                                objectParam = newArray;
                            } else if (compenentType == short.class) {
                                short newArray[] = new short[arrayLength];
                                objectParam = newArray;
                            } else if (compenentType == int.class) {
                                int newArray[] = new int[arrayLength];
                                objectParam = newArray;
                            } else if (compenentType == long.class) {
                                long newArray[] = new long[arrayLength];
                                objectParam = newArray;
                            } else if (compenentType == float.class) {
                                float newArray[] = new float[arrayLength];
                                objectParam = newArray;
                            } else if (compenentType == double.class) {
                                double newArray[] = new double[arrayLength];
                                objectParam = newArray;
                            } else {
                                throw new RuntimeException("primitive type " + compenentType + " not supported");
                            }
                        } else {
                            Object newArray[] = (Object[]) Array.newInstance(compenentType, arrayLength);
                            for (int j = 0; j < newArray.length; j++) {
                                newArray[j] = compenentType.newInstance();
                            }
                            objectParam = newArray;
                        }
                        Object editedObjectParam = ObjTableJPanel.editObject(objectParam, parentJFrame, queryString, true, null, null, null);
////                        logPrintln("editedObjectParam = " + editedObjectParam);
//                       if (!compenentType.isPrimitive()) {
//                            Object editedObjectParamAsArray[] = (Object[]) editedObjectParam;
//                            logPrintln("editedObjectParamAsArray = " + Arrays.toString(editedObjectParamAsArray));
//                        }
                        objectParams[i] = editedObjectParam;
                    } else if (parameterType.isEnum()) {
                        Object[] enumConstants = (Object[]) parameterType.getEnumConstants();
                        objectParam = JOptionPane.showInputDialog(parentJFrame, queryString, queryString, JOptionPane.QUESTION_MESSAGE, null, enumConstants, enumConstants[0]);
                        objectParams[i] = objectParam;
                    } else if (parameterType.isPrimitive()) {
                        if (parameterType == int.class) {
                            int paramInt = Integer.parseInt(JOptionPane.showInputDialog(parentJFrame, queryString, 0));
//                            logPrintln("paramInt = " + paramInt);
                            objectParams[i] = paramInt;
                        } else if (parameterType == double.class) {
                            double paramDouble = Double.parseDouble(JOptionPane.showInputDialog(parentJFrame, queryString, 0.0));
//                            logPrintln("paramDouble = " + paramDouble);
                            objectParams[i] = paramDouble;
                        } else {
                            objectParam = parameterType.newInstance();
                            Object editedObjectParam = ObjTableJPanel.editObject(objectParam, parentJFrame, queryString, true, null, null, null);
                            logPrintln("editedObjectParam = " + editedObjectParam);
                            objectParams[i] = editedObjectParam;
                        }
                    } else {
                        objectParam = parameterType.newInstance();
                        Object editedObjectParam = ObjTableJPanel.editObject(objectParam, parentJFrame, queryString, true, null, null, null);
//                        logPrintln("editedObjectParam = " + editedObjectParam);
                        objectParams[i] = editedObjectParam;
                    }
                    argsMap.put(i + ":" + parameterType + ":" + paramName, objectParams[i]);
                }
                boolean origMpcDebug = mpc.isDebug();
                mpc.setDebug(true);
                logPrintln("argsMap = " + argsMap);
                Object returnValue = selectedMethod.invoke(mpc, objectParams);
                mpc.setDebug(origMpcDebug);
                logPrintln("returnValue = " + returnValue);
                ObjTableJPanel.editObject(returnValue, parentJFrame, "returnValue", true, null, null, null);
            } catch (Exception ex) {
                appendLog(ex.getMessage());
                Logger.getLogger(MotomanCrclServerJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonSendRequestActionPerformed

    private void updateConnection() {
        if (this.jCheckBoxConnect.isSelected()) {
            try {
                disconnectCrclMotoplus();
                crclPort = Integer.parseInt(jTextFieldCrclPort.getText());
                motomanPort = Integer.parseInt(jTextFieldMotoplusPort.getText().trim());
                motomanHost = jTextFieldMotoplusHost.getText();
                connectCrclMotoplus();
            } catch (Exception ex) {
                errLogPrintln("crclPort = " + crclPort);
                errLogPrintln("motomanPort = " + motomanPort);
                errLogPrintln("motomanHost = " + motomanHost);
                LOGGER.log(Level.SEVERE, null, ex);
            }
        } else {
            disconnectCrclMotoplus();
        }
    }
    private static final Logger LOGGER = Logger.getLogger(MotomanCrclServerJPanel.class.getName());

    private File propertiesFile;

    /**
     * Get the value of propertiesFile
     *
     * @return the value of propertiesFile
     */
    public File getPropertiesFile() {
        return propertiesFile;
    }

    /**
     * Set the value of propertiesFile
     *
     * @param propertiesFile new value of propertiesFile
     */
    public void setPropertiesFile(File propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public void saveProperties() throws IOException {
        Properties props = new Properties();
        props.put(CRCL_PORT_PROPERTY_NAME, jTextFieldCrclPort.getText());
        props.put(MOTOPLUS_PORT_PROPERTY_NAME, jTextFieldMotoplusPort.getText());
        props.put(MOTOPLUS_HOST_PROPERTY_NAME, jTextFieldMotoplusHost.getText());
        props.put("debug", Boolean.toString(jCheckBoxDebug.isSelected()));

        logPrintln("MotomanCrclServerJPanel saving properties to " + propertiesFile.getCanonicalPath());
//        try (FileWriter fw = new FileWriter(propertiesFile)) {
//            props.store(fw, "");
//        }
        PropertiesUtils.saveProperties(propertiesFile, props);
    }
    private static final String MOTOPLUS_HOST_PROPERTY_NAME = "MOTOPLUS_HOST";
    private static final String MOTOPLUS_PORT_PROPERTY_NAME = "MOTOPLUS_PORT";
    private static final String CRCL_PORT_PROPERTY_NAME = "CRCL_PORT";

    public void setCrclPort(int port) {
        this.jTextFieldCrclPort.setText(Integer.toString(port));
        crclPort = Integer.parseInt(jTextFieldCrclPort.getText());
        updateConnection();
    }

    public int getCrclPort() {
        return crclPort;
    }

    public void loadProperties() throws IOException {
        Properties props = new Properties();
        logPrintln("MotomanCrclServerJPanel loading properties from " + propertiesFile.getCanonicalPath());
        try (FileReader fr = new FileReader(propertiesFile)) {
            props.load(fr);
        }
        String crclPortString = props.getProperty(CRCL_PORT_PROPERTY_NAME);
        if (null != crclPortString) {
            jTextFieldCrclPort.setText(crclPortString);
        }
        String motoplusPortString = props.getProperty(MOTOPLUS_PORT_PROPERTY_NAME);
        if (null != motoplusPortString) {
            jTextFieldMotoplusPort.setText(motoplusPortString);
        }
        String motomanHostString = props.getProperty(MOTOPLUS_HOST_PROPERTY_NAME);
        if (null != motomanHostString) {
            jTextFieldMotoplusHost.setText(motomanHostString);
        }
        crclPort = Integer.parseInt(jTextFieldCrclPort.getText());
        motomanPort = Integer.parseInt(jTextFieldMotoplusPort.getText());
        motomanHost = jTextFieldMotoplusHost.getText();
        String debugString = props.getProperty("debug");
        if (debugString != null && debugString.length() > 0 && Boolean.valueOf(debugString)) {
            jCheckBoxDebug.setSelected(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSendRequest;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxConnect;
    private javax.swing.JCheckBox jCheckBoxDebug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelMotoPlusCrclCommunications;
    private javax.swing.JPanel jPanelTelnet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaErrLog;
    private javax.swing.JTextField jTextFieldCrclPort;
    private javax.swing.JTextField jTextFieldMotoplusHost;
    private javax.swing.JTextField jTextFieldMotoplusPort;
    private com.github.wshackle.crcl4java.motoman.ui.TelnetJPanel telnetJPanel1;
    // End of variables declaration//GEN-END:variables
}
