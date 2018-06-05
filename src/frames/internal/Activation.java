/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames.internal;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class Activation extends javax.swing.JInternalFrame {

    /**
     * Creates new form Activation
     */
    public Activation() {
        initComponents();
        labelWaitingProgress.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        textfieldSN = new javax.swing.JTextField();
        buttonActivateBySN = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        textfieldEmail = new javax.swing.JTextField();
        comboboxUSBDrive = new javax.swing.JComboBox();
        buttonActivateByUSB = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        labelStatusVersion = new javax.swing.JLabel();
        labelWaitingProgress = new javax.swing.JLabel();

        setTitle("Activation");
        setPreferredSize(new java.awt.Dimension(400, 222));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new java.awt.GridLayout(3, 0));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serial Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        textfieldSN.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel9.add(textfieldSN);

        buttonActivateBySN.setText("Activate");
        buttonActivateBySN.setPreferredSize(new java.awt.Dimension(90, 30));
        buttonActivateBySN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActivateBySNActionPerformed(evt);
            }
        });
        jPanel9.add(buttonActivateBySN);

        jPanel8.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USB Activation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        textfieldEmail.setText("your email");
        textfieldEmail.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel10.add(textfieldEmail);
        jPanel10.add(comboboxUSBDrive);

        buttonActivateByUSB.setText("Activate");
        buttonActivateByUSB.setPreferredSize(new java.awt.Dimension(90, 30));
        buttonActivateByUSB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActivateByUSBActionPerformed(evt);
            }
        });
        jPanel10.add(buttonActivateByUSB);

        jPanel8.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        labelStatusVersion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStatusVersion.setForeground(new java.awt.Color(255, 255, 255));
        labelStatusVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatusVersion.setText("Lite Version (limited features)");
        labelStatusVersion.setPreferredSize(new java.awt.Dimension(350, 14));
        jPanel11.add(labelStatusVersion);

        labelWaitingProgress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelWaitingProgress.setForeground(new java.awt.Color(255, 255, 255));
        labelWaitingProgress.setText("waiting...");
        labelWaitingProgress.setPreferredSize(new java.awt.Dimension(60, 15));
        jPanel11.add(labelWaitingProgress);

        jPanel8.add(jPanel11);

        getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActivateBySNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActivateBySNActionPerformed
        Dashboard.writeToConsole("Serial Number was accepted!");
    }//GEN-LAST:event_buttonActivateBySNActionPerformed

    private void buttonActivateByUSBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActivateByUSBActionPerformed
        Dashboard.writeToConsole("USB activation was accepted!");
    }//GEN-LAST:event_buttonActivateByUSBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActivateBySN;
    private javax.swing.JButton buttonActivateByUSB;
    private javax.swing.JComboBox<String> comboboxUSBDrive;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelStatusVersion;
    private javax.swing.JLabel labelWaitingProgress;
    private javax.swing.JTextField textfieldEmail;
    private javax.swing.JTextField textfieldSN;
    // End of variables declaration//GEN-END:variables
}
