package data;

import data.controller.DBOperations;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class User {

    private String pass, name, type;
    int id;
    private boolean loggedIn;

    public static final int FACEBOOK = 1, TWITTER = 2, GOOGLE = 3;

    // for database column usage
    public static final String TEXT_FACEBOOK_USERNAME = "facebook_username",
            TEXT_GOOGLE_USERNAME = "google_username",
            TEXT_TWITTER_USERNAME = "twitter_username",
            TEXT_FACEBOOK_PASS = "facebook_pass",
            TEXT_TWITTER_PASS = "twitter_pass",
            TEXT_GOOGLE_PASS = "google_pass",
            TEXT_FACEBOOK = "facebook",
            TEXT_GOOGLE = "google",
            TEXT_TWITTER = "twitter",
            TEXT_ALL_SOCIAL_MEDIA = "all",
            TEXT_NAME = "name",
            TEXT_PASS = "pass",
            TEXT_TYPE = "type",
            TEXT_ID = "id";

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param aName the name to set
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param aType the type to set
     */
    public void setType(String aType) {
        type = aType;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean validate() {

        boolean stat = DBOperations.validateUser(this);
        // connecting to DB
        setLoggedIn(stat);

        return stat;

    }

    public String getDBSocialMediaValues() {
        String columnValues = null;
        if (this.getType().equalsIgnoreCase(TEXT_FACEBOOK)) {
            columnValues = TEXT_FACEBOOK_USERNAME + "=?";
            columnValues += ", " + TEXT_FACEBOOK_PASS + "=?";
        } else if (this.getType().equalsIgnoreCase(TEXT_GOOGLE)) {
            columnValues = TEXT_GOOGLE_USERNAME + "=?";
            columnValues += ", " + TEXT_GOOGLE_PASS + "=?";
        } else if (this.getType().equalsIgnoreCase(TEXT_TWITTER)) {
            columnValues = TEXT_TWITTER_USERNAME + "=?";
            columnValues += ", " + TEXT_TWITTER_PASS + "=?";
        }

        return columnValues;
    }

    public String getDBSocialMediaSettingValues() {
        String columnVal = null;

        if (this.getType().equalsIgnoreCase(TEXT_FACEBOOK)) {
            columnVal = SettingValues.TEXT_FACEBOOK_ACT_STATUS + "=?";
        } else if (this.getType().equalsIgnoreCase(TEXT_GOOGLE)) {
            columnVal = SettingValues.TEXT_GOOGLE_ACT_STATUS + "=?";
        } else if (this.getType().equalsIgnoreCase(TEXT_TWITTER)) {
            columnVal = SettingValues.TEXT_TWITTER_ACT_STATUS + "=?";
        }

        return columnVal;
    }

    public String getDBUserValues() {
        String columnValues = null;
        
        columnValues = TEXT_NAME +"=?," + TEXT_PASS+"=?" + " WHERE " + TEXT_ID+"=?";
        
        return columnValues;
    }

}
