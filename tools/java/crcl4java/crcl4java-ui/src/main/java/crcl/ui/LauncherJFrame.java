/* 
 * This is public domain software, however it is preferred
 * that the following disclaimers be attached.
 * 
 * Software Copywrite/Warranty Disclaimer
 * 
 * This software was developed at the National Institute of Standards and
 * Technology by employees of the Federal Government in the course of their
 * official duties. Pursuant to title 17 Section 105 of the United States
 * Code this software is not subject to copyright protection and is in the
 * public domain. This software is experimental.
 * NIST assumes no responsibility whatsoever for its use by other
 * parties, and makes no guarantees, expressed or implied, about its
 * quality, reliability, or any other characteristic. We would appreciate
 * acknowledgment if the software is used. This software can be
 * redistributed and/or modified freely provided that any derivative works
 * bear some notice that they are derived from it, and any modified
 * versions bear some notice that they have been modified.
 * 
 */
package crcl.ui;

import crcl.ui.server.GripperJFrame;
import crcl.ui.server.SimServerJFrame;
import crcl.ui.client.CrclSwingClientJFrame;
import static crcl.ui.IconImages.DONE_IMAGE;
import crcl.ui.forcetorquesensorsimulator.ForceTorqueSimJFrame;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Will Shackleford{@literal <william.shackleford@nist.gov> }
 */
@SuppressWarnings("serial")
public class LauncherJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LauncherJFrame
     */
    @SuppressWarnings({"nullness","initialization"})
    public LauncherJFrame() {
        initComponents();
        this.setIconImage(DONE_IMAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"all"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLaunchServer = new javax.swing.JButton();
        jButtonLaunchClient = new javax.swing.JButton();
        jButtonLaunchGripperServer = new javax.swing.JButton();
        jButtonLaunchAll = new javax.swing.JButton();
        jCheckBoxClient = new javax.swing.JCheckBox();
        jCheckBoxSimulationServer = new javax.swing.JCheckBox();
        jCheckBoxGripperServer = new javax.swing.JCheckBox();
        jCheckBoxForceTorqueSensorSimulator = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        jButtonLaunchServer.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jButtonLaunchServer.setText("Launch Simulated  CRCL Server  ");
        jButtonLaunchServer.addActionListener(formListener);

        jButtonLaunchClient.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jButtonLaunchClient.setText("Launch CRCL Client");
        jButtonLaunchClient.addActionListener(formListener);

        jButtonLaunchGripperServer.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jButtonLaunchGripperServer.setText("Launch Simulated  Gripper Server  ");
        jButtonLaunchGripperServer.addActionListener(formListener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRCL Launcher");

        jButtonLaunchAll.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jButtonLaunchAll.setText("Launch");
        jButtonLaunchAll.addActionListener(formListener);

        jCheckBoxClient.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jCheckBoxClient.setSelected(true);
        jCheckBoxClient.setText("CRCL Client");

        jCheckBoxSimulationServer.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jCheckBoxSimulationServer.setSelected(true);
        jCheckBoxSimulationServer.setText("CRCL Simulation Server");

        jCheckBoxGripperServer.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jCheckBoxGripperServer.setText("CRCL Simulation Gripper Server");

        jCheckBoxForceTorqueSensorSimulator.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jCheckBoxForceTorqueSensorSimulator.setSelected(true);
        jCheckBoxForceTorqueSensorSimulator.setText("CRCL Force Torque Sensor Simulator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLaunchAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxClient)
                            .addComponent(jCheckBoxSimulationServer)
                            .addComponent(jCheckBoxGripperServer))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBoxForceTorqueSensorSimulator)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSimulationServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxGripperServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxForceTorqueSensorSimulator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLaunchAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jButtonLaunchAll) {
                LauncherJFrame.this.jButtonLaunchAllActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonLaunchServer) {
                LauncherJFrame.this.jButtonLaunchServerActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonLaunchClient) {
                LauncherJFrame.this.jButtonLaunchClientActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonLaunchGripperServer) {
                LauncherJFrame.this.jButtonLaunchGripperServerActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonLaunchServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaunchServerActionPerformed
        startSimServer();
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButtonLaunchServerActionPerformed

    public void startSimServer() {
        SimServerJFrame newSimServerJFrame = new SimServerJFrame();
        newSimServerJFrame.setVisible(true);
    }

    private void jButtonLaunchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaunchClientActionPerformed
        startPendantClient();
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButtonLaunchClientActionPerformed

    public void startPendantClient() {
        try {
            new CrclSwingClientJFrame().setVisible(true);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LauncherJFrame.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    private void jButtonLaunchGripperServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaunchGripperServerActionPerformed
        startGripperServer();
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButtonLaunchGripperServerActionPerformed

    private void jButtonLaunchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaunchAllActionPerformed
        try {
            SimServerJFrame simServer;
            if (jCheckBoxSimulationServer.isSelected()) {
                simServer = new SimServerJFrame();
                simServer.setVisible(true);
                simServer.setState(Frame.ICONIFIED);
            } else {
                simServer = null;
            }
            if (jCheckBoxGripperServer.isSelected()) {
                GripperJFrame gripperJFrame = new GripperJFrame();
                gripperJFrame.setVisible(true);
                gripperJFrame.setState(Frame.ICONIFIED);
            }
            CrclSwingClientJFrame pendantClient;
            if (jCheckBoxClient.isSelected()) {
                pendantClient = new CrclSwingClientJFrame();
                pendantClient.setVisible(true);
                javax.swing.Timer timer = new javax.swing.Timer(500,
                        e -> {
                            if (jCheckBoxSimulationServer.isSelected() && simServer != null) {
                                pendantClient.connect("localhost", simServer.getPort());
                            }
                        }
                );
                timer.setRepeats(false);
                timer.start();
            } else {
                pendantClient=null;
            }
            if (jCheckBoxForceTorqueSensorSimulator.isSelected()) {
                ForceTorqueSimJFrame forceTorqueSensorSim = new ForceTorqueSimJFrame();
                if (null != pendantClient) {
                    forceTorqueSensorSim.setCrclClientPanel(pendantClient.getPendantClientJPanel1());
                }
                forceTorqueSensorSim.setVisible(true);
                forceTorqueSensorSim.startServer();
            }
//            if (jCheckBoxWebServer.isSelected()) {
//                WebServerJFrame webServer = new WebServerJFrame();
//                webServer.setVisible(true);
//                webServer.setState(Frame.ICONIFIED);
//                webServer.start();
//            }
        } catch (Exception ex) {
            Logger.getLogger(LauncherJFrame.class.getName()).log(Level.SEVERE, "evt=" + evt, ex);
        }
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButtonLaunchAllActionPerformed

    public void startGripperServer() {
        new GripperJFrame().setVisible(true);
    }

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
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(LauncherJFrame.class.getName()).log(java.util.logging.Level.SEVERE, "", ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LauncherJFrame ljf = new LauncherJFrame();
                ljf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLaunchAll;
    private javax.swing.JButton jButtonLaunchClient;
    private javax.swing.JButton jButtonLaunchGripperServer;
    private javax.swing.JButton jButtonLaunchServer;
    private javax.swing.JCheckBox jCheckBoxClient;
    private javax.swing.JCheckBox jCheckBoxForceTorqueSensorSimulator;
    private javax.swing.JCheckBox jCheckBoxGripperServer;
    private javax.swing.JCheckBox jCheckBoxSimulationServer;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(LauncherJFrame.class.getName());
}
