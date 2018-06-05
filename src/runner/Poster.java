package runner;

import data.CurrentUser;
import data.PostEntry;
import data.SettingValues;
import data.User;
import data.controller.DBOperations;
import frames.internal.Dashboard;
import helper.SoundPlayer;
import helper.ui.TimerEffect;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author @FgroupIndonesia.com
 */
public class Poster extends TimerTask {

    private final Timer timer;
    private PostEntry data;
    private DateFormat dateFormat;
    private int ranMinuteMs = 0, ranActualMinute = 0;
    private int currNumber = 0;
    private TimerEffect labelEffector;
    private JLabel labelRef;

    public Poster(Timer timer, int num, JLabel labelIn) {
        this.timer = timer;
        this.currNumber = num;
        this.labelRef = labelIn;
        prepareAccounts();
    }

    private void prepareAccounts() {
        CurrentUser.AkunFB.setUsername(SettingValues.getFacebookUser().getName());
        CurrentUser.AkunFB.setPass(SettingValues.getFacebookUser().getPass());

        CurrentUser.AkunGG.setUsername(SettingValues.getGoogleUser().getName());
        CurrentUser.AkunGG.setPass(SettingValues.getGoogleUser().getPass());

        CurrentUser.AkunTW.setUsername(SettingValues.getTwitterUser().getName());
        CurrentUser.AkunTW.setPass(SettingValues.getTwitterUser().getPass());
    }

    private void doFacebookPost(PostEntry dataMasuk) {
        try {

            if (dataMasuk.getAttachmentFile() != null) {
                CurrentUser.FacebookPoster.post(new File(dataMasuk.getAttachmentFile()), dataMasuk.getMessage());
            } else {
                CurrentUser.FacebookPoster.post(dataMasuk.getMessage());
            }

            Dashboard.writeToConsole("Facebook post for [" + dataMasuk.getTitle() + "] was success!");

        } catch (Exception ex) {
            Dashboard.writeToConsole("Facebook post for [" + dataMasuk.getTitle() + "] was failed!");
        }

    }

    private void doGooglePost(PostEntry dataMasuk) {

        try {
            if (dataMasuk.getAttachmentFile() != null) {
                if (CurrentUser.accountGoogleLoggedIn != true) {

                    CurrentUser.GooglePoster.login(CurrentUser.AkunGG);
                    // now toggle it once succeed logged in
                    // for the next post nomore logging in
                    CurrentUser.accountGoogleLoggedIn = true;
                }

                CurrentUser.GooglePoster.post(new File(dataMasuk.getAttachmentFile()), dataMasuk.getMessage());
            } else {
                CurrentUser.GooglePoster.post(dataMasuk.getMessage());
            }

            Dashboard.writeToConsole("Google post for [" + dataMasuk.getTitle() + "] was success!");
        } catch (Exception ex) {
            Dashboard.writeToConsole("Google post for [" + dataMasuk.getTitle() + "] was failed!");
        }

    }

    private void doTwitterPost(PostEntry dataMasuk) {

        try {
            if (dataMasuk.getAttachmentFile() != null) {
                CurrentUser.TwitterPoster.post(new File(dataMasuk.getAttachmentFile()), dataMasuk.getMessage());
            } else {
                CurrentUser.TwitterPoster.post(dataMasuk.getMessage());
            }

            Dashboard.writeToConsole("Twitter post for [" + dataMasuk.getTitle() + "] was success!");
        } catch (Exception ex) {
            Dashboard.writeToConsole("Twitter post for [" + dataMasuk.getTitle() + "] was failed!");
        }

    }

    // this will execute the SocNetSDKv2 accordingly
    // without freezing the frame
    private void postNow(PostEntry dataMasuk) {

        new Thread() {
            @Override
            public void run() {

                if (!dataMasuk.getSocialMediaProfile().contains(User.TEXT_ALL_SOCIAL_MEDIA)) {
                    // when only specific sosmed are selected

                    if (dataMasuk.getSocialMediaProfileActive().contains(User.TEXT_FACEBOOK)) {
                        doFacebookPost(dataMasuk);
                    }

                    if (dataMasuk.getSocialMediaProfileActive().contains(User.TEXT_GOOGLE)) {
                        doGooglePost(dataMasuk);
                    }

                    if (dataMasuk.getSocialMediaProfileActive().contains(User.TEXT_TWITTER)) {
                        doTwitterPost(dataMasuk);
                    }
                } else {
                    // when all sosmed are actives
                    doTwitterPost(dataMasuk);
                    doFacebookPost(dataMasuk);
                    doGooglePost(dataMasuk);

                }
            }
        }.start();

    }

    @Override
    public void run() {
        // calling the socnetsdk to work!
        data = getOnePost();

        if (data != null) {
            // do posting over here
            postNow(data);

            // calculate current number
            currNumber++;

            ranMinuteMs = getRandomMinute();
            ranActualMinute = (ranMinuteMs / 1000) / 60;

            data.setStatus(PostEntry.VALUE_STATUS_SUCCESS);
            data.setLastPosted(getCurrentDate());
            updatePostStatus(data);

            Dashboard.refreshTable();

            SoundPlayer.play(SoundPlayer.POP_FILE);

            // get the next post if any
            data = getOnePost();

            if (data != null) {

                Dashboard.writeToConsole("Waiting for the next post within..." + ranActualMinute + " minute(s).");

                timer.schedule(new Poster(timer, currNumber, labelRef), ranMinuteMs);
                CurrentUser.addExecution(timer);

                // make some appearance
                labelEffector = new TimerEffect();
                labelEffector.setTargetLabel(this.getLabelRef());
                labelEffector.setLimitInterval(ranActualMinute);
                labelEffector.execute();
            } else {
                complete();
            }

        } else {
            complete();
        }

    }

    private void complete() {

        SoundPlayer.play(SoundPlayer.HORRAY_FILE);
        Dashboard.writeToConsole("All posts have executed succesfully!");
        Dashboard.writeToConsole(currNumber + " Post(s) were successfully posted!");
        Dashboard.lockAllButtons(false);

        // ensuring nomore timertask available
        CurrentUser.stopAllExecution();

        // close any browser if any opened browser available
        CurrentUser.GooglePoster.closeBrowser();

    }

    private void updatePostStatus(PostEntry postIn) {
        // update the data
        DBOperations.savePost(postIn, postIn.getId());
    }

    private PostEntry getOnePost() {
        data = DBOperations.getFirstRowWaitingPost();
        return data;

    }

    private String getCurrentDate() {

        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }

        Date date = new Date();
        return dateFormat.format(date);
    }

    private int getRandomMinute() {

        int min = DBOperations.getLimitInterval();
        int nilaiAcakBulat = 0;

        // if we got 0, thus we pick another number
        while (nilaiAcakBulat == 0) {
            double nilaiAcak = Math.random() * min;
            nilaiAcakBulat = (int) nilaiAcak;
        }

        // because each second is 1000ms
        // and 1 minute is 60s
        return nilaiAcakBulat * 1000 * 60;
    }

    /**
     * @return the labelRef
     */
    public JLabel getLabelRef() {
        return labelRef;
    }

    /**
     * @param labelRef the labelRef to set
     */
    public void setLabelRef(JLabel labelRef) {
        this.labelRef = labelRef;
    }
}
