package helper.ui;

import configuration.Logger;
import frames.MainFrame;
import frames.internal.Dashboard;
import frames.internal.Login;
import frames.internal.Post;
import frames.internal.About;
import frames.internal.Settings;
import frames.internal.SocialMediaProfile;
import frames.internal.Activation;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import data.User;
import data.PostEntry;
import data.controller.DBOperations;
import frames.internal.AttachmentPreview;

import java.awt.Dimension;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class Opener {

    static MainFrame mFrame = null;
    static AttachmentPreview apframe = null;
    static About abframe = null;
    static Activation actframe = null;
    static Login lgframe = null;
    static SocialMediaProfile smframe = null;
    static Settings stframe = null;
    static Dashboard dsframe = null;
    static Post posframe = null;
    static JDesktopPane odesk = null;
    static User ouser = null;
    static PostEntry postData = null;
    static DBOperations dbInteraction = null;

    public static final int NEW_FORM = 8, EDIT_FORM = 7;
    private static String alamat = null;
    private static final String FRAME_NAME_ACTIVATION = "ACTIVATION",
            FRAME_NAME_SETTINGS = "SETTINGS", FRAME_NAME_ABOUT = "ABOUT",
            FRAME_NAME_SOCIALMEDIAPROFILE = "SOCIALMEDIAPROFILE", FRAME_NAME_LOGIN = "LOGIN",
            FRAME_NAME_POSTENTRY = "POSTENTRY", FRAME_NAME_DASHBOARD = "DASHBOARD",
            FRAME_NAME_ATTACHMENT_PREVIEW = "ATTACHMENTPREVIEW";

    public Opener(MainFrame mframe1) {
        mFrame = mframe1;
    }

    public static MainFrame getMainFrame() {
        return mFrame;
    }

    public void setDesktopPane(JDesktopPane obDesk) {
        odesk = obDesk;
    }

    public static void setUser(User obUser) {
        ouser = obUser;
    }

    public static void showAttachmentPreviewFrame(String alamatMasuk) {
        alamat = alamatMasuk;
        showDialog(9, apframe);
    }

    public static void showActivationFrame() {
        showDialog(6, actframe);
    }

    public static void showSocialMediaFrame(User dataIn, Settings frameIn) {
        ouser = dataIn;
        stframe = frameIn;
        showDialog(5, smframe);
    }

    public static void showSettingsFrame() {
        showDialog(4, stframe);
    }

    public static void showAboutFrame() {
        showDialog(3, abframe);
    }

    public static void showDashboardFrame() {
        showDialog(2, dsframe);
    }

    public static void showLoginFrame() {
        showDialog(1, lgframe);
    }

    public static void setData(PostEntry pr) {
        postData = pr;
    }

    public static void showPostFrame(int statusForm) {

        // 8 is NEW
        // 7 is EDIT
        showDialog(statusForm, posframe);

    }

    public static void closeFrame() {

        try {
            odesk.getSelectedFrame().dispose();
        } catch (Exception ex) {
            String pesan = "Error on closeFrame()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

    }

    private static void showDialog(int frameNumber, JInternalFrame obFrame) {
        try {
            if (obFrame == null) {

                switch (frameNumber) {
                    case 1:
                        obFrame = new Login();
                        obFrame.setName(FRAME_NAME_LOGIN);
                        mFrame.setSettingMenu(true);
                        break;
                    case 2:
                        obFrame = new Dashboard(ouser);
                        obFrame.setName(FRAME_NAME_DASHBOARD);
                        break;
                    case 3:
                        obFrame = new About();
                        obFrame.setName(FRAME_NAME_ABOUT);
                        break;
                    case 4:
                        obFrame = new Settings();
                        obFrame.setName(FRAME_NAME_SETTINGS);
                        ((Settings) obFrame).setMainFrame(mFrame);
                        break;
                    case 5:
                        // the userprofile give the data
                        // and setting frame as reference
                        obFrame = new SocialMediaProfile(ouser, stframe);
                        obFrame.setName(FRAME_NAME_SOCIALMEDIAPROFILE);
                        break;
                    case 6:
                        obFrame = new Activation();
                        obFrame.setName(FRAME_NAME_ACTIVATION);
                        break;
                    case 7:
                        // editing Post
                        obFrame = new Post(postData);
                        obFrame.setName(FRAME_NAME_POSTENTRY);
                        break;
                    case 8:
                        // new Post
                        obFrame = new Post(ouser);
                        obFrame.setName(FRAME_NAME_POSTENTRY);
                        break;
                    case 9:
                        // attachment preview
                        obFrame = new AttachmentPreview(alamat);
                        obFrame.setName(FRAME_NAME_ATTACHMENT_PREVIEW);
                        break;
                    default:

                }

            } else if (obFrame.isClosed() == true) {
                odesk.remove(obFrame);

            }

            odesk.add(obFrame);
            obFrame.setVisible(true);

            Dimension desktopSize = odesk.getSize();
            Dimension jInternalFrameSize = obFrame.getSize();
            obFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);

            obFrame.setClosable(true);

            if (frameNumber == 2) {
                // dashboard in maximum size
                obFrame.setMaximum(true);
            }

        } catch (Exception ex) {
            
            String pesan = "Error showDialog()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }
    }

}
