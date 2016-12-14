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
package crcl.ui.server;

import crcl.base.LengthUnitEnumType;
import crcl.utils.outer.interfaces.SimServerMenuOuter;
import crcl.utils.outer.interfaces.SimServerOuter;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
public class SimServerJInternalFrame extends javax.swing.JInternalFrame implements SimServerOuter, SimServerMenuOuter, AutoCloseable {

    /**
     * Creates new form SimServerJInternalFrame
     */
    public SimServerJInternalFrame() {
        initComponents();
        this.simServerJPanel1.setMenuOuter(this);
        this.simServerJPanel1.restartServer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            simServerJPanel1 = new crcl.ui.server.SimServerJPanel();
        } catch (javax.xml.parsers.ParserConfigurationException e1) {
            e1.printStackTrace();
        }
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemEditStatus = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemSetSchema = new javax.swing.JMenuItem();
        jCheckBoxMenuItemValidateXML = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jCheckBoxMenuItemRandomPacket = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemAppendZero = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemIncludeGripperStatus = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemReplaceState = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemDebugMoveDone = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemDebugReadCommand = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemDebugSendStatus = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemReplaceXmlHeader = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemEXI = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemLogImages = new javax.swing.JCheckBoxMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemViewCommandLogBrief = new javax.swing.JMenuItem();
        jMenuItemViewCommandLogFull = new javax.swing.JMenuItem();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CRCL SImulation Server");

        jMenu1.setText("File");

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItemEditStatus.setText("Status in Table ...");
        jMenuItemEditStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditStatusActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEditStatus);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("XML Schemas");

        jMenuItemSetSchema.setText("Set Schema File(s)  ... ");
        jMenuItemSetSchema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSetSchemaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemSetSchema);

        jCheckBoxMenuItemValidateXML.setSelected(true);
        jCheckBoxMenuItemValidateXML.setText("Validate XML with Schema(s)");
        jMenu3.add(jCheckBoxMenuItemValidateXML);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Options");

        jCheckBoxMenuItemRandomPacket.setText("Randomize Packeting");
        jMenu4.add(jCheckBoxMenuItemRandomPacket);

        jCheckBoxMenuItemAppendZero.setText("Append 0 for string termination");
        jMenu4.add(jCheckBoxMenuItemAppendZero);

        jCheckBoxMenuItemIncludeGripperStatus.setText("Connect to Gripper Server ...");
        jCheckBoxMenuItemIncludeGripperStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemIncludeGripperStatusActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItemIncludeGripperStatus);

        jCheckBoxMenuItemReplaceState.setText("Replace CRCL_Working,CRCL_Done with Working,Done ...");
        jMenu4.add(jCheckBoxMenuItemReplaceState);

        jCheckBoxMenuItemDebugMoveDone.setText("Debug MOVE Done");
        jMenu4.add(jCheckBoxMenuItemDebugMoveDone);

        jCheckBoxMenuItemDebugReadCommand.setText("Debug Read Command");
        jMenu4.add(jCheckBoxMenuItemDebugReadCommand);

        jCheckBoxMenuItemDebugSendStatus.setText("Debug Send Status");
        jMenu4.add(jCheckBoxMenuItemDebugSendStatus);

        jCheckBoxMenuItemReplaceXmlHeader.setSelected(true);
        jCheckBoxMenuItemReplaceXmlHeader.setText("Replace XML Headers");
        jMenu4.add(jCheckBoxMenuItemReplaceXmlHeader);

        jCheckBoxMenuItemEXI.setText("Use EXI (Efficient XML Interchange)");
        jCheckBoxMenuItemEXI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemEXIActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItemEXI);

        jCheckBoxMenuItemLogImages.setText("Log Images");
        jCheckBoxMenuItemLogImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemLogImagesActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItemLogImages);

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemAbout);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Tools");

        jMenuItemViewCommandLogBrief.setText("View Command Log Brief");
        jMenuItemViewCommandLogBrief.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemViewCommandLogBriefActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemViewCommandLogBrief);

        jMenuItemViewCommandLogFull.setText("View Command Log Full");
        jMenuItemViewCommandLogFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemViewCommandLogFullActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemViewCommandLogFull);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simServerJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simServerJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemEditStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditStatusActionPerformed
        simServerJPanel1.editStatusAction();
    }//GEN-LAST:event_jMenuItemEditStatusActionPerformed

    private void jMenuItemSetSchemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSetSchemaActionPerformed
        simServerJPanel1.setSchemaAction();
    }//GEN-LAST:event_jMenuItemSetSchemaActionPerformed

    private void jCheckBoxMenuItemIncludeGripperStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemIncludeGripperStatusActionPerformed
        if (this.jCheckBoxMenuItemIncludeGripperStatus.isSelected()) {
            simServerJPanel1.setIncludeGripperAction();
        }
    }//GEN-LAST:event_jCheckBoxMenuItemIncludeGripperStatusActionPerformed

    private void jCheckBoxMenuItemEXIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemEXIActionPerformed
        simServerJPanel1.restartServer();
    }//GEN-LAST:event_jCheckBoxMenuItemEXIActionPerformed

    private void jCheckBoxMenuItemLogImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemLogImagesActionPerformed
        //        this.overHeadJPanel1.setLogImages(this.jCheckBoxMenuItemLogImages.isSelected());
        //        this.sideViewJPanel1.setLogImages(this.jCheckBoxMenuItemLogImages.isSelected());
        simServerJPanel1.setLogImages(jCheckBoxMenuItemLogImages.isSelected());
    }//GEN-LAST:event_jCheckBoxMenuItemLogImagesActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        simServerJPanel1.aboutAction();
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jMenuItemViewCommandLogBriefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemViewCommandLogBriefActionPerformed
        simServerJPanel1.viewCommandLogBriefAction();
    }//GEN-LAST:event_jMenuItemViewCommandLogBriefActionPerformed

    private void jMenuItemViewCommandLogFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemViewCommandLogFullActionPerformed
        simServerJPanel1.viewCommandLogFullAction();
    }//GEN-LAST:event_jMenuItemViewCommandLogFullActionPerformed

    
    @Override
    public boolean isDebugMoveDoneSelected() {
        return this.jCheckBoxMenuItemDebugMoveDone.isSelected();
    }

    @Override
    public boolean isDebugReadCommandSelected() {
        return this.jCheckBoxMenuItemDebugReadCommand.isSelected();
    }

    @Override
    public boolean isDebugSendStatusSelected() {
        return this.jCheckBoxMenuItemDebugSendStatus.isSelected();
    }

    @Override
    public void updateConnectedClients(int numClients) {
        simServerJPanel1.updateConnectedClients(numClients);
    }

    @Override
    public void updateCycleCount(int _newCycleCount) {
        simServerJPanel1.updateCycleCount(_newCycleCount);
    }

    @Override
    public void updatePanels(boolean jointschanged) {
        simServerJPanel1.updatePanels(jointschanged);
    }

    @Override
    public void updateIsInitialized(boolean initialized) {
        simServerJPanel1.updateIsInitialized(initialized);
    }

    @Override
    public void updateCurrentCommandType(String cmdName) {
        simServerJPanel1.updateCurrentCommandType(cmdName);
    }

    @Override
    public void updateEndEffector(String text) {
        simServerJPanel1.updateEndEffector(text);
    }

    @Override
    public void updateToolChangerIsOpen(boolean isOpen) {
        simServerJPanel1.updateToolChangerIsOpen(isOpen);
    }

    @Override
    public void showMessage(String msgString) {
        simServerJPanel1.showMessage(msgString);
    }

    @Override
    public void finishSetCurrentWaypoint(int currentWaypoint) {
        simServerJPanel1.finishSetCurrentWaypoint(currentWaypoint);
    }

    @Override
    public void updateLengthUnit(LengthUnitEnumType lu) {
        simServerJPanel1.updateLengthUnit(lu);
    }

    @Override
    public void showDebugMessage(String s) {
        simServerJPanel1.showDebugMessage(s);
    }

    @Override
    public void updateNumWaypoints(int numWaypoints) {
        simServerJPanel1.updateNumWaypoints(numWaypoints);
    }

    @Override
    public boolean isInitializedSelected() {
        return simServerJPanel1.isInitializedSelected();
    }

    @Override
    public boolean isSendStatusWithoutRequestSelected() {
        return simServerJPanel1.isSendStatusWithoutRequestSelected();
    }

    @Override
    public boolean isAppendZeroSelected() {
        return jCheckBoxMenuItemAppendZero.isSelected();
    }

    @Override
    public boolean isReplaceXmlHeaderSelected() {
        return jCheckBoxMenuItemReplaceXmlHeader.isSelected();
    }

    @Override
    public boolean isRandomPacketSelected() {
        return jCheckBoxMenuItemRandomPacket.isSelected();
    }

    @Override
    public boolean isReplaceStateSelected() {
        return jCheckBoxMenuItemReplaceState.isSelected();
    }

    @Override
    public boolean isEditingStatus() {
        return simServerJPanel1.isEditingStatus();
    }

    @Override
    public boolean isEXISelected() {
        return jCheckBoxMenuItemEXI.isSelected();
    }

    @Override
    public boolean isValidateXMLSelected() {
        return jCheckBoxMenuItemValidateXML.isSelected();
    }
    
    public int getPort() {
        return simServerJPanel1.getPort();
    }

    @Override
    public SimServerMenuOuter getMenuOuter() {
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemAppendZero;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDebugMoveDone;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDebugReadCommand;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDebugSendStatus;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemEXI;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemIncludeGripperStatus;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemLogImages;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemRandomPacket;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemReplaceState;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemReplaceXmlHeader;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemValidateXML;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemEditStatus;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemSetSchema;
    private javax.swing.JMenuItem jMenuItemViewCommandLogBrief;
    private javax.swing.JMenuItem jMenuItemViewCommandLogFull;
    private crcl.ui.server.SimServerJPanel simServerJPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void close() throws Exception {
        simServerJPanel1.restartServer();
        this.setVisible(false);
    }
}
