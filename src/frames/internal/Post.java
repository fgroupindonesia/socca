package frames.internal;

import configuration.Logger;
import data.CurrentUser;
import data.PostEntry;
import data.User;
import data.controller.DBOperations;

import helper.ui.Opener;
import helper.ui.PictureResizer;
import helper.ui.TextEffect;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class Post extends javax.swing.JInternalFrame {
    
    TextEffect txhelper = new TextEffect();
    String location_pic1;
    PostEntry dataEdited = null;

    /**
     * Creates new form Post
     */
    public Post() {
        initComponents();
        txhelper.addTextfield(txtfield_title);
        txhelper.addTextarea(txtfield_message);
        txhelper.switchCaret();
    }
    
    public Post(User ouser) {
        // new form
        initComponents();
        txhelper.addTextfield(txtfield_title);
        txhelper.addTextarea(txtfield_message);
        txhelper.switchCaret();
        this.setName("New Post");
    }
    
    public Post(PostEntry dataIn) {
        // new form
        initComponents();
        dataEdited = dataIn;
        txtfield_message.setText(dataIn.getMessage());
        txtfield_title.setText(dataIn.getTitle());
        
        if (dataIn.getSocialMediaProfile().equalsIgnoreCase(PostEntry.VALUE_SOCIAL_MEDIA_ALL)) {
            radioButtonAllSocialMedia.setSelected(true);
            checkboxFacebook.setSelected(true);
            checkboxGooglePlus.setSelected(true);
            checkboxTwitter.setSelected(true);
        } else {
            // when only specific social media are selected
            radioButtonSpecificSocialMedia.setSelected(true);
            renderCheckboxSelected(dataIn);
        }
        
        setTitle(dataIn.getTitle() + "{" + dataIn.getStatus() + "}");
        setPicture1Location(dataIn.getAttachmentFile());
        
        txhelper.addTextfield(txtfield_title);
        txhelper.addTextarea(txtfield_message);
        txhelper.switchCaret();
        this.setName("Edit Post");
        
        btn_save.setText("Update");
    }
    
    private void renderCheckboxSelected(data.PostEntry dataIn) {
        
        if (dataIn.getSocialMediaProfileActive().contains(data.PostEntry.VALUE_SOCIAL_MEDIA_FACEBOOK)) {
            checkboxFacebook.setSelected(true);
        }
        
        if (dataIn.getSocialMediaProfileActive().contains(data.PostEntry.VALUE_SOCIAL_MEDIA_TWITTER)) {
            checkboxTwitter.setSelected(true);
        }
        
        if (dataIn.getSocialMediaProfileActive().contains(data.PostEntry.VALUE_SOCIAL_MEDIA_GOOGLE)) {
            checkboxGooglePlus.setSelected(true);
        }
        
    }
    
    public String getPicture1Location() {
        return location_pic1;
    }
    
    public void setPicture1Location(String nPathValue) {
        location_pic1 = nPathValue;
        
        if (nPathValue != null) {
            
            try {
                BufferedImage originalImage = ImageIO.read(new File(nPathValue));
                ImageIcon gbr = new ImageIcon(PictureResizer.resizeImagePreview(originalImage));
                labelPicture1Preview.setIcon(gbr);
                labelPicture1Preview.setText("");
            } catch (Exception ex) {
                
                String pesan = "Error setPicture1Location()" + ex.getMessage();
                System.err.println(pesan);
                Logger.showMessage(pesan);
            }
        } else {
            labelPicture1Preview.setText("no picture selected!");
        }
        
    }
    
    public String getFromSocialMediaCheckbox() {
        
        String allText = "";
        
        if (checkboxFacebook.isSelected()) {
            allText += checkboxFacebook.getText();
        }
        if (checkboxTwitter.isSelected()) {
            if (allText.length() != 0) {
                allText += "," + checkboxTwitter.getText();
            } else {
                allText += checkboxTwitter.getText();
            }
        }
        if (checkboxGooglePlus.isSelected()) {
            
            if (allText.length() != 0) {
                allText += "," + checkboxGooglePlus.getText();
            } else {
                allText += checkboxGooglePlus.getText();
            }
        }
        
        return allText;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiogroup_socialmedia = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtfield_message = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btn_pic2 = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_pic1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtfield_title = new javax.swing.JTextField();
        radioButtonSpecificSocialMedia = new javax.swing.JRadioButton();
        radioButtonAllSocialMedia = new javax.swing.JRadioButton();
        checkboxGooglePlus = new javax.swing.JCheckBox();
        checkboxFacebook = new javax.swing.JCheckBox();
        checkboxTwitter = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        labelPicture1Preview = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(51, 51, 51));
        setClosable(true);
        setTitle("New Post");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(394, 430));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfield_message.setBackground(new java.awt.Color(153, 153, 153));
        txtfield_message.setColumns(20);
        txtfield_message.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtfield_message.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_message.setRows(5);
        txtfield_message.setText("type something here");
        txtfield_message.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfield_messageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfield_messageFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtfield_message);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 220, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Title : ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        btn_pic2.setBackground(new java.awt.Color(204, 255, 0));
        btn_pic2.setText("Picture 2");
        btn_pic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pic2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 100, -1));

        btn_save.setBackground(new java.awt.Color(204, 255, 0));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Attachments : ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Social Media Profiles:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 20));

        btn_pic1.setBackground(new java.awt.Color(204, 255, 0));
        btn_pic1.setText("Picture 1");
        btn_pic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pic1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Message : ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, -1));

        txtfield_title.setBackground(new java.awt.Color(153, 153, 153));
        txtfield_title.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_title.setText("type something here");
        txtfield_title.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfield_titleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfield_titleFocusLost(evt);
            }
        });
        jPanel2.add(txtfield_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 200, -1));

        radioButtonSpecificSocialMedia.setBackground(new java.awt.Color(51, 51, 51));
        radiogroup_socialmedia.add(radioButtonSpecificSocialMedia);
        radioButtonSpecificSocialMedia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioButtonSpecificSocialMedia.setForeground(new java.awt.Color(255, 255, 255));
        radioButtonSpecificSocialMedia.setText("Specific On :");
        radioButtonSpecificSocialMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonSpecificSocialMediaActionPerformed(evt);
            }
        });
        jPanel2.add(radioButtonSpecificSocialMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        radioButtonAllSocialMedia.setBackground(new java.awt.Color(51, 51, 51));
        radiogroup_socialmedia.add(radioButtonAllSocialMedia);
        radioButtonAllSocialMedia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioButtonAllSocialMedia.setForeground(new java.awt.Color(255, 255, 255));
        radioButtonAllSocialMedia.setText("All");
        radioButtonAllSocialMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonAllSocialMediaActionPerformed(evt);
            }
        });
        jPanel2.add(radioButtonAllSocialMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 50, -1));

        checkboxGooglePlus.setBackground(new java.awt.Color(51, 51, 51));
        checkboxGooglePlus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkboxGooglePlus.setForeground(new java.awt.Color(255, 255, 255));
        checkboxGooglePlus.setText("google+");
        jPanel2.add(checkboxGooglePlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        checkboxFacebook.setBackground(new java.awt.Color(51, 51, 51));
        checkboxFacebook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkboxFacebook.setForeground(new java.awt.Color(255, 255, 255));
        checkboxFacebook.setText("facebook");
        jPanel2.add(checkboxFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        checkboxTwitter.setBackground(new java.awt.Color(51, 51, 51));
        checkboxTwitter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkboxTwitter.setForeground(new java.awt.Color(255, 255, 255));
        checkboxTwitter.setText("twitter");
        jPanel2.add(checkboxTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 240, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        labelPicture1Preview.setForeground(new java.awt.Color(255, 255, 255));
        labelPicture1Preview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPicture1Preview.setText("no picture selected!");
        labelPicture1Preview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(labelPicture1Preview, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 220, 160));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(394, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfield_titleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfield_titleFocusGained
        txhelper.animateFocusGain_JTextfield();
    }//GEN-LAST:event_txtfield_titleFocusGained

    private void txtfield_titleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfield_titleFocusLost
        txhelper.animateFocusLost_JTextfield();
    }//GEN-LAST:event_txtfield_titleFocusLost

    private void txtfield_messageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfield_messageFocusGained
        txhelper.animateFocusGain_JTextarea();
    }//GEN-LAST:event_txtfield_messageFocusGained

    private void txtfield_messageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfield_messageFocusLost
        txhelper.animateFocusLost_JTextarea();
    }//GEN-LAST:event_txtfield_messageFocusLost

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        
        if (dataEdited == null) {
            dataEdited = new PostEntry();
        }
        
        dataEdited.setAttachmentFile(getPicture1Location());
        dataEdited.setTitle(txtfield_title.getText());
        dataEdited.setMessage(txtfield_message.getText());
        
        dataEdited.setLastPosted(null);
        dataEdited.setStatus(PostEntry.VALUE_STATUS_WAIT);
        
        if (radioButtonAllSocialMedia.isSelected()) {
            dataEdited.setSocialMediaProfile(PostEntry.VALUE_SOCIAL_MEDIA_ALL);
            dataEdited.setSocialMediaProfileActive(PostEntry.VALUE_SOCIAL_MEDIA_ALL);
        } else {
            dataEdited.setSocialMediaProfile(PostEntry.VALUE_SOCIAL_MEDIA_SPECIFIC);
            String socMediaSelected = getFromSocialMediaCheckbox();
            dataEdited.setSocialMediaProfileActive(socMediaSelected);
        }
        
        if (btn_save.getText().equalsIgnoreCase("save") != true) {

            // lets update the data
            DBOperations.savePost(dataEdited, dataEdited.getId());
            
        } else {

            // lets save the new data
            DBOperations.savePost(dataEdited);
            
        }
        
        Dashboard.refreshTable();
        Dashboard.writeToConsole("Data " + dataEdited.getTitle() + " was saved succesfully!");
        
        Opener.closeFrame();

    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_pic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pic1ActionPerformed
        
        jFileChooser1.setDialogTitle("Select an image");
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
        jFileChooser1.addChoosableFileFilter(filter);
        
        if (CurrentUser.LastLocationBrowsePicture != null) {
            jFileChooser1.setCurrentDirectory(new File(CurrentUser.LastLocationBrowsePicture));
        }
        
        int returnValue = jFileChooser1.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // obtaining the absolute filelocation
            setPicture1Location(jFileChooser1.getSelectedFile().getPath());
            
            Dashboard.writeToConsole("File attached : " + getPicture1Location());

            // saving the location for later usage
            CurrentUser.LastLocationBrowsePicture = jFileChooser1.getSelectedFile().getParent();
        }
        

    }//GEN-LAST:event_btn_pic1ActionPerformed

    private void btn_pic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pic2ActionPerformed
        JOptionPane.showMessageDialog(this, "This features only available on Premium version", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btn_pic2ActionPerformed

    private void radioButtonSpecificSocialMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonSpecificSocialMediaActionPerformed
        selectAllSocialMediaProfiles(false);
    }//GEN-LAST:event_radioButtonSpecificSocialMediaActionPerformed

    private void radioButtonAllSocialMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonAllSocialMediaActionPerformed
        selectAllSocialMediaProfiles(true);
    }//GEN-LAST:event_radioButtonAllSocialMediaActionPerformed
    
    private void selectAllSocialMediaProfiles(boolean stat) {
        
        checkboxFacebook.setEnabled(!stat);
        checkboxGooglePlus.setEnabled(!stat);
        checkboxTwitter.setEnabled(!stat);
        
        checkboxFacebook.setSelected(stat);
        checkboxGooglePlus.setSelected(stat);
        checkboxTwitter.setSelected(stat);
        
    }
    
    private String getNumberDigit(String valIn) {
        
        int val = Integer.parseInt(valIn);
        
        String zeroDigit = null;
        if (val < 10) {
            zeroDigit = "0";
        } else {
            zeroDigit = "";
        }
        
        return zeroDigit + val;
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pic1;
    private javax.swing.JButton btn_pic2;
    private javax.swing.JButton btn_save;
    private javax.swing.JCheckBox checkboxFacebook;
    private javax.swing.JCheckBox checkboxGooglePlus;
    private javax.swing.JCheckBox checkboxTwitter;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPicture1Preview;
    private javax.swing.JRadioButton radioButtonAllSocialMedia;
    private javax.swing.JRadioButton radioButtonSpecificSocialMedia;
    private javax.swing.ButtonGroup radiogroup_socialmedia;
    private javax.swing.JTextArea txtfield_message;
    private javax.swing.JTextField txtfield_title;
    // End of variables declaration//GEN-END:variables
}
