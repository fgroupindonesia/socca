package frames.internal;

import data.User;
import data.controller.DBOperations;
import helper.ui.Opener;
import helper.ui.TextEffect;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author @FgroupIndonesia.com
 */
public class SocialMediaProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form SocialMediaProfile
     */
    TextEffect txhelper = new TextEffect();
    Settings frameRef1 = null;
    User oneProfile = new User();

    public SocialMediaProfile() {
        defaultInits();
    }

    public SocialMediaProfile(User dataMasuk, Settings frameRef) {
        defaultInits();

        frameRef1 = frameRef;
        oneProfile = dataMasuk;

        if (dataMasuk != null) {
            textfieldPass.setText(dataMasuk.getPass());
            textfieldUsername.setText(dataMasuk.getName());
        }

        TitledBorder titleBor = (TitledBorder) panelAccount.getBorder();
        titleBor.setTitle(dataMasuk.getType() + " Account");

        oneProfile.setType(dataMasuk.getType());
    }

    private void defaultInits() {
        initComponents();

        txhelper.addTextfield(textfieldUsername);
        txhelper.addPasswordfield(textfieldPass);
        txhelper.switchCaret();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSave = new javax.swing.JButton();
        panelAccount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textfieldUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textfieldPass = new javax.swing.JPasswordField();

        setTitle("Social Media Profile");
        setPreferredSize(new java.awt.Dimension(300, 125));

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave, java.awt.BorderLayout.PAGE_END);

        panelAccount.setBackground(new java.awt.Color(51, 51, 51));
        panelAccount.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelAccount.setLayout(new java.awt.GridLayout(2, 2));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username :");
        panelAccount.add(jLabel1);

        textfieldUsername.setBackground(new java.awt.Color(153, 153, 153));
        textfieldUsername.setForeground(new java.awt.Color(255, 255, 255));
        textfieldUsername.setText("type something here");
        textfieldUsername.setPreferredSize(new java.awt.Dimension(250, 20));
        textfieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfieldUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textfieldUsernameFocusLost(evt);
            }
        });
        textfieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldUsernameActionPerformed(evt);
            }
        });
        panelAccount.add(textfieldUsername);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password :");
        panelAccount.add(jLabel2);

        textfieldPass.setBackground(new java.awt.Color(153, 153, 153));
        textfieldPass.setForeground(new java.awt.Color(255, 255, 255));
        textfieldPass.setText("type something here");
        textfieldPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfieldPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textfieldPassFocusLost(evt);
            }
        });
        textfieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldPassActionPerformed(evt);
            }
        });
        panelAccount.add(textfieldPass);

        getContentPane().add(panelAccount, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textfieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfieldUsernameFocusGained
        txhelper.animateFocusGain_JTextfield();
    }//GEN-LAST:event_textfieldUsernameFocusGained

    private void textfieldUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfieldUsernameFocusLost
        txhelper.animateFocusLost_JTextfield();
    }//GEN-LAST:event_textfieldUsernameFocusLost

    private void textfieldPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfieldPassFocusGained
        txhelper.animateFocusGain_JPassword();
    }//GEN-LAST:event_textfieldPassFocusGained

    private void textfieldPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfieldPassFocusLost
        txhelper.animateFocusLost_JPassword();
    }//GEN-LAST:event_textfieldPassFocusLost

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        saveData();
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void textfieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldUsernameActionPerformed
        saveData();
    }//GEN-LAST:event_textfieldUsernameActionPerformed

    private void textfieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldPassActionPerformed
        saveData();
    }//GEN-LAST:event_textfieldPassActionPerformed

    private void saveData() {

        oneProfile.setName(textfieldUsername.getText());
        oneProfile.setPass(textfieldPass.getText());

        // will do the updating on both database
        DBOperations.saveSocialMediaProfile(oneProfile);

        // refreshing the settings back
        frameRef1.refreshData();
        Opener.closeFrame();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelAccount;
    private javax.swing.JPasswordField textfieldPass;
    private javax.swing.JTextField textfieldUsername;
    // End of variables declaration//GEN-END:variables
}
