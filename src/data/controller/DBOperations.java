package data.controller;

import configuration.ConfigReader;
import configuration.Logger;
import data.PostEntry;
import data.SettingValues;
import data.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class is pure using SQLite database for all INSERT, SELECT, DELETE, and
 * UPDATE statements
 *
 * @author (c) www.fgroupindonesia.com
 */
public class DBOperations {

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:" + ConfigReader.getDBFilePath();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {

            String pesan = "Error connect()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }
        return conn;
    }

    public static void activateSocialMediaProfile(boolean stat, User dataIn) {
        String sql = "UPDATE system_settings SET " + dataIn.getDBSocialMediaSettingValues();

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            pstmt.setBoolean(1, stat);

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            String pesan = "Error activateSocialMediaProfile()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

    }

    public static void saveSocialMediaProfile(User dataMasuk) {
        // each column is defined
        String sql = "UPDATE social_media_profiles SET " + dataMasuk.getDBSocialMediaValues();

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            pstmt.setString(1, dataMasuk.getName());
            pstmt.setString(2, dataMasuk.getPass());

            pstmt.executeUpdate();

            activateSocialMediaProfile(true, dataMasuk);

        } catch (SQLException ex) {

            String pesan = "Error saveSocialMediaProfile()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }
    }

    public static void savePost(PostEntry newData, int nomorID) {
        String sql = "UPDATE posts SET " + newData.getDBValues() + " WHERE id=?";

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            pstmt.setString(1, newData.getTitle());
            pstmt.setString(2, newData.getMessage());
            pstmt.setString(3, newData.getAttachmentFile());
            pstmt.setString(4, newData.getSocialMediaProfile());
            pstmt.setString(5, newData.getSocialMediaProfileActive());
            pstmt.setString(6, newData.getStatus());
            pstmt.setString(7, newData.getLastPosted());
            pstmt.setInt(8, nomorID);

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            String pesan = "Error savingPost()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }
    }

    public static void savePost(PostEntry newData) {
        String sql = "INSERT INTO posts VALUES(null, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            pstmt.setString(1, newData.getTitle());
            pstmt.setString(2, newData.getMessage());
            pstmt.setString(3, newData.getAttachmentFile());
            pstmt.setString(4, newData.getSocialMediaProfile());
            pstmt.setString(5, newData.getSocialMediaProfileActive());
            pstmt.setString(6, newData.getStatus());
            pstmt.setString(7, newData.getLastPosted());
            pstmt.executeUpdate();

        } catch (SQLException ex) {

            String pesan = "Error savingPost()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }
    }

    public static void deletePost(int idNum) {

        String sql = "DELETE FROM posts WHERE id=?";

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, idNum);
            pstmt.executeUpdate();

        } catch (SQLException ex) {

            String pesan = "Error deletePost()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

    }

    public static ArrayList getAllPosts() {

        String sql = "SELECT * FROM posts";
        ArrayList kumpulanTerbaca = new ArrayList();

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                PostEntry dataTerbaca = new PostEntry();
                dataTerbaca.setId(hasil.getInt(PostEntry.TEXT_ID));
                dataTerbaca.setTitle(hasil.getString(PostEntry.TEXT_TITLE));
                dataTerbaca.setMessage(hasil.getString(PostEntry.TEXT_MESSAGE));
                dataTerbaca.setAttachmentFile(hasil.getString(PostEntry.TEXT_ATTACHMENT_FILE));
                dataTerbaca.setSocialMediaProfile(hasil.getString(PostEntry.TEXT_SOCIAL_MEDIA_PROFILE));
                dataTerbaca.setSocialMediaProfileActive(hasil.getString(PostEntry.TEXT_SOCIAL_MEDIA_PROFILE_ACTIVE));
                dataTerbaca.setStatus(hasil.getString(PostEntry.TEXT_STATUS));
                dataTerbaca.setLastPosted(hasil.getString(PostEntry.TEXT_LAST_POSTED));

                kumpulanTerbaca.add(dataTerbaca);
            }

        } catch (SQLException ex) {

            String pesan = "Error getAllPosts()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

        return kumpulanTerbaca;

    }

    public static User getSocialMediaProfile(int userProfile) {

        String sql = "SELECT * FROM social_media_profiles";
        User dataTerbaca = null;

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                dataTerbaca = new User();
                if (userProfile == User.FACEBOOK) {
                    dataTerbaca.setName(hasil.getString(User.TEXT_FACEBOOK_USERNAME));
                    dataTerbaca.setPass(hasil.getString(User.TEXT_FACEBOOK_PASS));
                }

                if (userProfile == User.GOOGLE) {
                    dataTerbaca.setName(hasil.getString(User.TEXT_GOOGLE_USERNAME));
                    dataTerbaca.setPass(hasil.getString(User.TEXT_GOOGLE_PASS));
                }

                if (userProfile == User.TWITTER) {
                    dataTerbaca.setName(hasil.getString(User.TEXT_TWITTER_USERNAME));
                    dataTerbaca.setPass(hasil.getString(User.TEXT_TWITTER_PASS));
                }

            }

        } catch (SQLException ex) {

            String pesan = "Error getSocialMediaProfiles()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

        return dataTerbaca;

    }

    public static boolean validateUser(User dataMasuk) {

        String sql = "SELECT * FROM users_socca WHERE name=? AND pass=?";
        User dataTerbaca = null;
        boolean dataDitemukan = false;

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            pstmt.setString(1, dataMasuk.getName());
            pstmt.setString(2, dataMasuk.getPass());

            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                dataDitemukan = true;
            }

        } catch (SQLException ex) {

            String pesan = "Error getUser()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

        return dataDitemukan;

    }

    public static void saveUser(User dataIn) {

        String sql = "UPDATE users_socca SET " + dataIn.getDBUserValues();

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            pstmt.setString(1, dataIn.getName());
            pstmt.setString(2, dataIn.getPass());
            pstmt.setInt(3, dataIn.getId());

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            String pesan = "Error saveUser()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

    }

    public static PostEntry getFirstRowWaitingPost() {

        String sql = "SELECT * FROM posts WHERE status='waiting' ORDER BY id ASC LIMIT 1";
        PostEntry dataTerbaca = null;

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                dataTerbaca = new PostEntry();
                dataTerbaca.setId(hasil.getInt(PostEntry.TEXT_ID));
                dataTerbaca.setTitle(hasil.getString(PostEntry.TEXT_TITLE));
                dataTerbaca.setMessage(hasil.getString(PostEntry.TEXT_MESSAGE));
                dataTerbaca.setAttachmentFile(hasil.getString(PostEntry.TEXT_ATTACHMENT_FILE));
                dataTerbaca.setSocialMediaProfile(hasil.getString(PostEntry.TEXT_SOCIAL_MEDIA_PROFILE));
                dataTerbaca.setSocialMediaProfileActive(hasil.getString(PostEntry.TEXT_SOCIAL_MEDIA_PROFILE_ACTIVE));
                dataTerbaca.setStatus(hasil.getString(PostEntry.TEXT_STATUS));
                dataTerbaca.setLastPosted(hasil.getString(PostEntry.TEXT_LAST_POSTED));
            }

        } catch (SQLException ex) {

            String pesan = "Error getFirstRowWaitingPost()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

        return dataTerbaca;

    }

    public static PostEntry getPost(int nomerID) {

        String sql = "SELECT * FROM posts WHERE id=?";
        PostEntry dataTerbaca = null;

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            pstmt.setInt(1, nomerID);

            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                dataTerbaca = new PostEntry();
                dataTerbaca.setId(hasil.getInt(PostEntry.TEXT_ID));
                dataTerbaca.setTitle(hasil.getString(PostEntry.TEXT_TITLE));
                dataTerbaca.setMessage(hasil.getString(PostEntry.TEXT_MESSAGE));
                dataTerbaca.setAttachmentFile(hasil.getString(PostEntry.TEXT_ATTACHMENT_FILE));
                dataTerbaca.setSocialMediaProfile(hasil.getString(PostEntry.TEXT_SOCIAL_MEDIA_PROFILE));
                dataTerbaca.setSocialMediaProfileActive(hasil.getString(PostEntry.TEXT_SOCIAL_MEDIA_PROFILE_ACTIVE));
                dataTerbaca.setStatus(hasil.getString(PostEntry.TEXT_STATUS));
                dataTerbaca.setLastPosted(hasil.getString(PostEntry.TEXT_LAST_POSTED));
            }

        } catch (SQLException ex) {

            String pesan = "Error getPost()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

        return dataTerbaca;

    }

    public static User getUser(int nomerID) {

        String sql = "SELECT * FROM users_socca";
        User dataTerbaca = null;

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                dataTerbaca = new User();
                dataTerbaca.setId(hasil.getInt(User.TEXT_ID));
                dataTerbaca.setPass(hasil.getString(User.TEXT_PASS));
                dataTerbaca.setName(hasil.getString(User.TEXT_NAME));
                dataTerbaca.setType(hasil.getString(User.TEXT_TYPE));
            }

        } catch (SQLException ex) {

            String pesan = "Error getUser()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

        return dataTerbaca;

    }

    public static void saveSettings(SettingValues dataIn) {
        String sql = "UPDATE system_settings SET " + dataIn.getDBSettingValues();

        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);

            pstmt.setBoolean(1, dataIn.isStartup());
            pstmt.setString(2, dataIn.getCopyrightMessage());
            pstmt.setString(3, dataIn.getModeInterval());
            pstmt.setInt(4, dataIn.getLimitInterval());

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            String pesan = "Error saveSettings()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

    }

    public static SettingValues getSettings(int idUser) {

        String sql = "SELECT * FROM system_settings";

        SettingValues dataTerbaca = null;
        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                dataTerbaca = new SettingValues();
                dataTerbaca.setId(hasil.getInt(SettingValues.TEXT_ID));
                dataTerbaca.setStartup(hasil.getBoolean(SettingValues.TEXT_WINDOWS_STARTUP));
                dataTerbaca.setCopyrightMessage(hasil.getString(SettingValues.TEXT_COPYRIGHT_MESSAGE));

                dataTerbaca.setFacebookProfileActive(hasil.getBoolean(SettingValues.TEXT_FACEBOOK_ACT_STATUS));
                dataTerbaca.setTwitterProfileActive(hasil.getBoolean(SettingValues.TEXT_TWITTER_ACT_STATUS));
                dataTerbaca.setGoogleProfileActive(hasil.getBoolean(SettingValues.TEXT_GOOGLE_ACT_STATUS));

                dataTerbaca.setModeInterval(hasil.getString(SettingValues.TEXT_INTERVAL_MODE));
                dataTerbaca.setLimitInterval(hasil.getInt(SettingValues.TEXT_INTERVAL_LIMIT));

                if (dataTerbaca.isFacebookProfileActive()) {
                    User dataFB = getSocialMediaProfile(User.FACEBOOK);
                    dataFB.setType(User.TEXT_FACEBOOK);
                    dataTerbaca.setFacebookUser(dataFB);

                }

                if (dataTerbaca.isGoogleProfileActive()) {
                    User dataGoogle = getSocialMediaProfile(User.GOOGLE);
                    dataGoogle.setType(User.TEXT_GOOGLE);
                    dataTerbaca.setGoogleUser(dataGoogle);
                }

                if (dataTerbaca.isTwitterProfileActive()) {
                    User dataTwitter = getSocialMediaProfile(User.TWITTER);
                    dataTwitter.setType(User.TEXT_TWITTER);
                    dataTerbaca.setTwitterUser(dataTwitter);
                }

                User dataUserLogin = getUser(idUser);
                dataTerbaca.setDataUser(dataUserLogin);

            }

        } catch (SQLException ex) {
            String pesan = "Error getSettings()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

        return dataTerbaca;

    }

    public static int getLimitInterval() {

        String sql = "SELECT * FROM system_settings";
        int minutes = 0;

        SettingValues dataTerbaca = null;
        try {

            PreparedStatement pstmt = connect().prepareStatement(sql);
            ResultSet hasil = pstmt.executeQuery();

            while (hasil.next()) {
                minutes = hasil.getInt(SettingValues.TEXT_INTERVAL_LIMIT);
            }

        } catch (SQLException ex) {

            String pesan = "Error getLimitInterval()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }

        return minutes;

    }

}
