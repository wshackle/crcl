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
 *  This software is experimental. NIST assumes no responsibility whatsoever for its use by other
 * parties, and makes no guarantees, expressed or implied, about its
 * quality, reliability, or any other characteristic. We would appreciate
 * acknowledgement if the software is used. This software can be
 * redistributed and/or modified freely provided that any derivative works
 * bear some notice that they are derived from it, and any modified
 * versions bear some notice that they have been modified.
 * 
 */
package crcl.ui.server;

import crcl.base.CRCLCommandInstanceType;
import crcl.base.CRCLCommandType;
import crcl.base.CRCLStatusType;
import crcl.base.CommandStateEnumType;
import crcl.base.CommandStatusType;
import crcl.base.EndCanonType;
import crcl.base.GetStatusType;
import crcl.base.GripperStatusType;
import crcl.base.InitCanonType;
import crcl.base.ParallelGripperStatusType;
import crcl.base.SetEndEffectorType;
import crcl.base.ThreeFingerGripperStatusType;
import crcl.base.VacuumGripperStatusType;

import static crcl.ui.IconImages.SERVER_IMAGE;
import crcl.utils.CRCLSocket;
import crcl.utils.CRCLException;
import crcl.utils.CRCLUtils;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
@SuppressWarnings({"all","serialization"})
public class GripperJFrame extends javax.swing.JFrame {

    /**
     * Creates new form GripperJFrame
     */
    @SuppressWarnings({"nullness","initialization"})
    public GripperJFrame() {
        initComponents();
        this.jTextFieldPort.setText(Integer.toString(this.port));
        this.jTextFieldCycleTime.setText(Integer.toString(this.delayMillis));
        this.restartServer();
        super.setIconImage(SERVER_IMAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "nullness", "deprecation", "rawtypes","CanBeFinal"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCycleTime = new javax.swing.JTextField();
        jButtonReset = new javax.swing.JButton();
        jCheckBoxInitialized = new javax.swing.JCheckBox();
        jCheckBoxSendStatusWithoutRequest = new javax.swing.JCheckBox();
        jButtonRestartServer = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelThreeFinger = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThreeFinger = new javax.swing.JTable();
        jPanelVacuum = new javax.swing.JPanel();
        jCheckBoxVacuumPower = new javax.swing.JCheckBox();
        jPanelParallel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldParallelSeperation = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuOptions = new javax.swing.JMenu();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sim Gripper Server");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Setup"));

        jLabel5.setText("Port: ");

        jTextFieldPort.setText("4005  ");
        jTextFieldPort.addActionListener(formListener);

        jLabel6.setText("Cycle Time (ms): ");

        jTextFieldCycleTime.setText("1000");
        jTextFieldCycleTime.addActionListener(formListener);

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(formListener);

        jCheckBoxInitialized.setText("Initialized");

        jCheckBoxSendStatusWithoutRequest.setText("Send Status Without Requests");

        jButtonRestartServer.setText("Restart Server");
        jButtonRestartServer.addActionListener(formListener);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCycleTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jCheckBoxInitialized)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jCheckBoxSendStatusWithoutRequest))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonReset)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRestartServer))))
                .addGap(30, 30, 30))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldCycleTime, jTextFieldPort});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCycleTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonRestartServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxInitialized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSendStatusWithoutRequest))
        );

        jPanelThreeFinger.setName("ThreeFinger"); // NOI18N

        jTableThreeFinger.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jTableThreeFinger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1),  new Double(0.0), null},
                { new Integer(2),  new Double(0.0), null},
                { new Integer(3),  new Double(0.0), null}
            },
            new String [] {
                "Finger", "Position", "Force"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableThreeFinger);

        javax.swing.GroupLayout jPanelThreeFingerLayout = new javax.swing.GroupLayout(jPanelThreeFinger);
        jPanelThreeFinger.setLayout(jPanelThreeFingerLayout);
        jPanelThreeFingerLayout.setHorizontalGroup(
            jPanelThreeFingerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThreeFingerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelThreeFingerLayout.setVerticalGroup(
            jPanelThreeFingerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThreeFingerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("ThreeFinger", jPanelThreeFinger);

        jPanelVacuum.setName("Vacuum"); // NOI18N

        jCheckBoxVacuumPower.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jCheckBoxVacuumPower.setText("Power");

        javax.swing.GroupLayout jPanelVacuumLayout = new javax.swing.GroupLayout(jPanelVacuum);
        jPanelVacuum.setLayout(jPanelVacuumLayout);
        jPanelVacuumLayout.setHorizontalGroup(
            jPanelVacuumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVacuumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxVacuumPower)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanelVacuumLayout.setVerticalGroup(
            jPanelVacuumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVacuumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxVacuumPower)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vacuum", jPanelVacuum);

        jPanelParallel.setName("Parallel"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel1.setText("Seperation");

        jTextFieldParallelSeperation.setText("0.0");

        javax.swing.GroupLayout jPanelParallelLayout = new javax.swing.GroupLayout(jPanelParallel);
        jPanelParallel.setLayout(jPanelParallelLayout);
        jPanelParallelLayout.setHorizontalGroup(
            jPanelParallelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParallelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldParallelSeperation, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelParallelLayout.setVerticalGroup(
            jPanelParallelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParallelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParallelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldParallelSeperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parallel", jPanelParallel);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuOptions.setText("Options");
        jMenuBar1.add(jMenuOptions);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jTextFieldPort) {
                GripperJFrame.this.jTextFieldPortActionPerformed(evt);
            }
            else if (evt.getSource() == jTextFieldCycleTime) {
                GripperJFrame.this.jTextFieldCycleTimeActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonReset) {
                GripperJFrame.this.jButtonResetActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonRestartServer) {
                GripperJFrame.this.jButtonRestartServerActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPortActionPerformed
        this.setPort(Integer.parseInt(this.jTextFieldPort.getText()));
        this.restartServer();
    }//GEN-LAST:event_jTextFieldPortActionPerformed

    private void jTextFieldCycleTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCycleTimeActionPerformed
        this.setDelayMillis(Integer.parseInt(this.jTextFieldCycleTime.getText()));
        this.restartServer();
    }//GEN-LAST:event_jTextFieldCycleTimeActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonResetActionPerformed

    private int port = 4005;

    /**
     * Get the value of port
     *
     * @return the value of port
     */
    public int getPort() {
        return port;
    }

    /**
     * Set the value of port
     *
     * @param port new value of port
     */
    public void setPort(int port) {
        this.port = port;
    }

    private int delayMillis = 1000;

    /**
     * Get the value of delayMillis
     *
     * @return the value of delayMillis
     */
    public int getDelayMillis() {
        return delayMillis;
    }

    /**
     * Set the value of delayMillis
     *
     * @param delayMillis new value of delayMillis
     */
    public void setDelayMillis(int delayMillis) {
        this.delayMillis = delayMillis;
    }

    private @Nullable
    ServerSocket serverSocket = null;
    
    private @Nullable
    Thread acceptThread = null;
    
    private @Nullable
    Thread updateThread = null;
    
    final private List<CRCLSocket> clientsList
            = Collections.synchronizedList(new ArrayList<>());
    ;
    final private List<Thread> clientThreads
            = Collections.synchronizedList(new ArrayList<>());
    private final java.util.concurrent.LinkedBlockingQueue<CRCLCommandType> cmdQueue
            = new java.util.concurrent.LinkedBlockingQueue<>();
    private final CRCLStatusType status = new CRCLStatusType();

    private void close() {
        for (int i = 0; i < clientsList.size(); i++) {
            CRCLSocket cs = clientsList.get(i);
            try {
                cs.close();
            } catch (IOException ex) {
                Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
            }
        }
        clientsList.clear();
        if (null != serverSocket) {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
            }
            serverSocket = null;
        }
        if (null != acceptThread) {
            acceptThread.interrupt();
            try {
                acceptThread.join(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
            }
            acceptThread = null;
        }
        if (null != updateThread) {
            updateThread.interrupt();
            try {
                updateThread.join(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
            }
            updateThread = null;
        }
        if (null != cmdQueue) {
            cmdQueue.clear();
        }
        clientThreads.clear();
    }

    private @MonotonicNonNull ThreeFingerGripperStatusType threeFingerGripperStatus = null;
    private @MonotonicNonNull VacuumGripperStatusType vacuumGripperStatus = null;
    private @MonotonicNonNull ParallelGripperStatusType parallelGripperStatus = null;

    private void checkCommandQueue() {
        CRCLCommandType cmd = this.cmdQueue.poll();
        if (null != cmd) {
            CommandStatusType cst = status.getCommandStatus();
            if (cst == null) {
                cst = new CommandStatusType();
            }
            cst.setCommandID(cmd.getCommandID());
            status.setCommandStatus(cst);
            if (cmd instanceof InitCanonType) {
                this.jCheckBoxInitialized.setSelected(true);
            } else if (cmd instanceof EndCanonType) {
                this.jCheckBoxInitialized.setSelected(false);
            }
            if (this.jCheckBoxInitialized.isSelected()) {
                if (cmd instanceof SetEndEffectorType) {
                    SetEndEffectorType seeCmd = (SetEndEffectorType) cmd;
                    switch (this.jTabbedPane1.getSelectedComponent().getName()) {
                        case "ThreeFinger":
                            if (null == this.threeFingerGripperStatus) {
                                this.threeFingerGripperStatus = new ThreeFingerGripperStatusType();
                            }
                            this.threeFingerGripperStatus.setFinger1Position(seeCmd.getSetting());
                            this.threeFingerGripperStatus.setFinger2Position(seeCmd.getSetting());
                            this.threeFingerGripperStatus.setFinger3Position(seeCmd.getSetting());
                            this.jTableThreeFinger.getModel().setValueAt(seeCmd.getSetting(), 0, 1);
                            this.jTableThreeFinger.getModel().setValueAt(seeCmd.getSetting(), 1, 1);
                            this.jTableThreeFinger.getModel().setValueAt(seeCmd.getSetting(), 2, 1);
                            break;

                        case "Vacuum":
                            if (null == this.vacuumGripperStatus) {
                                this.vacuumGripperStatus = new VacuumGripperStatusType();
                            }
                            vacuumGripperStatus.setIsPowered(seeCmd.getSetting() < 0.5);
                            this.jCheckBoxVacuumPower.setSelected(vacuumGripperStatus.isIsPowered());
                            break;

                        case "Parallel":
                            if (null == this.parallelGripperStatus) {
                                this.parallelGripperStatus = new ParallelGripperStatusType();
                            }
                            parallelGripperStatus.setSeparation(seeCmd.getSetting());
                            this.jTextFieldParallelSeperation.setText(Double.toString(seeCmd.getSetting()));
                            break;

                        default:
                            System.err.println("Invalid selected component name: " + this.jTabbedPane1.getSelectedComponent().getName());
                            break;
                    }

                }
            }
        }
    }

    private static final CRCLSocket.UnaryOperator<String> NOP_FILTER = x -> x;

    private void updateStatus() {
        this.prepStatus();
        CommandStatusType cst 
                = CRCLUtils.getNonNullCommandStatus(status);
        long statusId = cst.getStatusID();
        cst.setStatusID(statusId + 1);
        switch (this.jTabbedPane1.getSelectedComponent().getName()) {
            case "ThreeFinger":
                if (null == this.threeFingerGripperStatus) {
                    this.threeFingerGripperStatus = new ThreeFingerGripperStatusType();
                }
                this.status.setGripperStatus(threeFingerGripperStatus);
                Double f1pos = (Double) this.jTableThreeFinger.getModel().getValueAt(0, 1);
                threeFingerGripperStatus.setFinger1Position(f1pos);
                Double f2pos = (Double) this.jTableThreeFinger.getModel().getValueAt(1, 1);
                threeFingerGripperStatus.setFinger2Position(f2pos);
                Double f3pos = (Double) this.jTableThreeFinger.getModel().getValueAt(2, 1);
                threeFingerGripperStatus.setFinger3Position(f3pos);
                Object f1forceObj = this.jTableThreeFinger.getModel().getValueAt(0, 2);
                if (null != f1forceObj) {
                    try {
                        double f1force = Double.parseDouble(f1forceObj.toString());
                        threeFingerGripperStatus.setFinger1Force(f1force);
                    } catch (NumberFormatException ignored) {
                    }
                }
                Object f2forceObj = this.jTableThreeFinger.getModel().getValueAt(1, 2);
                if (null != f2forceObj) {
                    try {
                        double f2force = Double.parseDouble(f2forceObj.toString());
                        threeFingerGripperStatus.setFinger2Force(f2force);
                    } catch (NumberFormatException ignored) {
                    }
                }
                Object f3forceObj = this.jTableThreeFinger.getModel().getValueAt(2, 2);
                if (null != f3forceObj) {
                    try {
                        double f3force = Double.parseDouble(f3forceObj.toString());
                        threeFingerGripperStatus.setFinger3Force(f3force);
                    } catch (NumberFormatException ignored) {
                    }
                }
                break;

            case "Vacuum":
                if (null == this.vacuumGripperStatus) {
                    this.vacuumGripperStatus = new VacuumGripperStatusType();
                }
                vacuumGripperStatus.setIsPowered(this.jCheckBoxVacuumPower.isSelected());
                this.status.setGripperStatus(vacuumGripperStatus);
                break;

            case "Parallel":
                if (null == this.parallelGripperStatus) {
                    this.parallelGripperStatus = new ParallelGripperStatusType();
                }
                try {
                    double sep = Double.parseDouble(this.jTextFieldParallelSeperation.getText());
                    parallelGripperStatus.setSeparation(sep);

                } catch (NumberFormatException ignored) {
                }
                this.status.setGripperStatus(parallelGripperStatus);
                break;

            default:
                System.err.println("Invalid selected component name: " + this.jTabbedPane1.getSelectedComponent().getName());
                break;
        }
        GripperStatusType gripperStatus = CRCLUtils.requireNonNull(this.status.getGripperStatus(), "this.status.getGripperStatus()");
        gripperStatus.setGripperName(this.jTabbedPane1.getSelectedComponent().getName());

        if (this.jCheckBoxSendStatusWithoutRequest.isSelected()) {
            if (clientsList.size() > 0) {
                try {
                    CRCLSocket cs0 = clientsList.get(0);
//                    if (jCheckBoxMenuItemReplaceState.isSelected()) {
//                        cs0.setStatusStringOutputFilter(CRCLSocket.removeCRCLFromState);
//                    } else {
//                        cs0.setStatusStringOutputFilter(NOP_FILTER);
//                    }
                    cs0.setStatusStringOutputFilter(NOP_FILTER);
                    String xmlS = cs0.statusToString(status, false);
                    for (int i = 0; i < clientsList.size(); i++) {
                        try {
                            CRCLSocket curClient = clientsList.get(i);
                            curClient.writeWithFill(xmlS);
                        } catch (IOException ex) {
                            Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
                            clientsList.remove(i);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
                        }
                    }
                } catch (CRCLException ex) {
                    Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
                }
            }
        }

    }

    private void prepStatus() {
        CommandStatusType cst = status.getCommandStatus();
        if (cst == null) {
            cst = new CommandStatusType();
            status.setCommandStatus(cst);
        }
        if (cst.getCommandID() < 1) {
            cst.setCommandID(1);
        }
        if (cst.getStatusID() < 1) {
            cst.setStatusID(1);
        }
        if (null == cst.getCommandState()) {
            cst.setCommandState(CommandStateEnumType.CRCL_DONE);
        }
    }

    private void acceptClient() throws IOException {
        try {
            if (null == serverSocket) {
                throw new IllegalStateException("null == serverSocket");
            }
            Socket s = serverSocket.accept();
            final CRCLSocket cs = new CRCLSocket(s);
            clientsList.add(cs);
            Thread t = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted() && cs.isConnected()) {
                    try {
                        CRCLCommandInstanceType cmdInstance = cs.readCommand(false);
                        if (null == cmdInstance) {
                            continue;
                        }
                        CRCLCommandType cmd = cmdInstance.getCRCLCommand();
                        if (cmd instanceof GetStatusType) {
                            prepStatus();
//                            if (jCheckBoxMenuItemReplaceState.isSelected()) {
//                                cs.setStatusStringOutputFilter(CRCLSocket.removeCRCLFromState);
//                            }
                            cs.setStatusStringOutputFilter(NOP_FILTER);
                            cs.writeStatus(status, false);
                        } else if (cmd != null) {
                            cmdQueue.put(cmd);
                        }
                    } catch (CRCLException ex) {
                        Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
                    } catch (IOException | InterruptedException iex) {
                        try {
                            cs.close();
                        } catch (Exception ignored) {
                        }
                        return;
                    }
                }
            }, "gripperClientThread" + clientsList.size());
            clientThreads.add(t);
            t.start();
        } catch (Exception ex) {
            Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    private void restartServer() {
        try {
            this.close();

            try {
                int new_port = Integer.parseInt(this.jTextFieldPort.getText());
                this.setPort(new_port);
            } catch (NumberFormatException ignored) {
            }
            try {
                int new_delay_millis = Integer.parseInt(this.jTextFieldCycleTime.getText());
                this.setDelayMillis(new_delay_millis);
            } catch (NumberFormatException ignored) {
            }
            this.serverSocket = new ServerSocket(this.port);
            acceptThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            acceptClient();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
                    }
                }

            }, "gripperAcceptThread");
            acceptThread.start();
            updateThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            Thread.sleep(delayMillis);
                            checkCommandQueue();
                            updateStatus();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
                    }
                }
            }, "gripperUpdateThread");
            updateThread.start();
        } catch (IOException ex) {
            Logger.getLogger(GripperJFrame.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        this.close();
//    }

    private void jButtonRestartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRestartServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRestartServerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GripperJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GripperJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GripperJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GripperJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GripperJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonRestartServer;
    private javax.swing.JCheckBox jCheckBoxInitialized;
    private javax.swing.JCheckBox jCheckBoxSendStatusWithoutRequest;
    private javax.swing.JCheckBox jCheckBoxVacuumPower;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelParallel;
    private javax.swing.JPanel jPanelThreeFinger;
    private javax.swing.JPanel jPanelVacuum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableThreeFinger;
    private javax.swing.JTextField jTextFieldCycleTime;
    private javax.swing.JTextField jTextFieldParallelSeperation;
    private javax.swing.JTextField jTextFieldPort;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(GripperJFrame.class.getName());
}
