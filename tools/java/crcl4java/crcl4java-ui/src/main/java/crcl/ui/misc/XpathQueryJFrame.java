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
package crcl.ui.misc;

import crcl.ui.client.CrclSwingClientJFrame;
import crcl.utils.XpathUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 *
 * @author Will Shackleford{@literal <william.shackleford@nist.gov> }
 */
public class XpathQueryJFrame extends javax.swing.JFrame {

    /**
     * Creates new form XpathQueryJFrame
     *
     * @throws javax.xml.parsers.ParserConfigurationException when
     * javax.xml.parsers.DocumentBuilderFactory fails in XpathUtils
     */
    @SuppressWarnings("initialization")
    public XpathQueryJFrame() throws ParserConfigurationException {
        initComponents();
        this.xpu = new XpathUtils();
        this.checkQuery();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxXpathQuery = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonClose = new javax.swing.JButton();
        jCheckBoxUpdateAutomatically = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRCL Status Xpath Query");

        jComboBoxXpathQuery.setEditable(true);
        jComboBoxXpathQuery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "/", "//JointStatus" }));
        jComboBoxXpathQuery.addActionListener(formListener);

        jLabel1.setText("Query: ");

        jLabel2.setText("Result:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(formListener);

        jCheckBoxUpdateAutomatically.setSelected(true);
        jCheckBoxUpdateAutomatically.setText("Update Automatically");
        jCheckBoxUpdateAutomatically.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jComboBoxXpathQuery, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBoxUpdateAutomatically)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jComboBoxXpathQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jCheckBoxUpdateAutomatically))
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jComboBoxXpathQuery) {
                XpathQueryJFrame.this.jComboBoxXpathQueryActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonClose) {
                XpathQueryJFrame.this.jButtonCloseActionPerformed(evt);
            }
            else if (evt.getSource() == jCheckBoxUpdateAutomatically) {
                XpathQueryJFrame.this.jCheckBoxUpdateAutomaticallyActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private String query;

    /**
     * Get the value of query
     *
     * @return the value of query
     */
    public String getQuery() {
        return query;
    }

    /**
     * Set the value of query
     *
     * @param query new value of query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    private String result;

    /**
     * Get the value of result
     *
     * @return the value of result
     */
    public String getResult() {
        return result;
    }

    public void setResult(final String _result) {
        this.result = _result;
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                jTextArea1.setText(_result);
            }
        });
    }

    private void jComboBoxXpathQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxXpathQueryActionPerformed
        checkQuery();
    }//GEN-LAST:event_jComboBoxXpathQueryActionPerformed

    private void jCheckBoxUpdateAutomaticallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUpdateAutomaticallyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxUpdateAutomaticallyActionPerformed

    private void checkQuery() {
        String q = this.jComboBoxXpathQuery.getSelectedItem().toString();
        boolean found = false;
        for (int i = 0; i < this.jComboBoxXpathQuery.getItemCount(); i++) {
            if (this.jComboBoxXpathQuery.getItemAt(i).equals(q)) {
                found = true;
                break;
            }
        }
        if (!found) {
            this.jComboBoxXpathQuery.addItem(q);
        }
        this.setQuery(q);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XpathQueryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XpathQueryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XpathQueryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XpathQueryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new XpathQueryJFrame().setVisible(true);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(XpathQueryJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Nullable
    String failedQuery = null;

    public void message(String s) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(XpathQueryJFrame.this, s);
            }
        });
    }

    final XpathUtils xpu;

    public boolean isUpdateAutomaticallySelected() {
        return this.jCheckBoxUpdateAutomatically.isSelected();
    }

    public @Nullable
    String runQuery(String query, String status) {
        String resultString = "";
        try {
            if (query.equals(failedQuery)) {
                return null;
            }
            resultString = xpu.queryXmlString(status, query);
        } catch (Exception ex) {
            Logger.getLogger(CrclSwingClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            message("Query :" + query + " of " + status + " failed");
            failedQuery = query;
        }
        this.setResult(resultString);
        return resultString;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JCheckBox jCheckBoxUpdateAutomatically;
    private javax.swing.JComboBox<String> jComboBoxXpathQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(XpathQueryJFrame.class.getName());
}
