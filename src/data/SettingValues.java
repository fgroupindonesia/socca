package data;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class SettingValues {

    private int id;
    private boolean startup;
    private User dataUser;
    private String modeInterval;
    private int limitInterval;
    private String copyrightMessage;
    private boolean facebookProfileActive;
    private boolean twitterProfileActive;
    private boolean googleProfileActive;
    private static User facebookUser;
    private static User twitterUser;
    private static User googleUser;

    // for column table purposes
    public static final String TEXT_ID = "id", TEXT_WINDOWS_STARTUP = "windows_startup",
            TEXT_COPYRIGHT_MESSAGE = "copyright_message", TEXT_FACEBOOK_ACT_STATUS = "facebook_active_status",
            TEXT_TWITTER_ACT_STATUS = "twitter_active_status", TEXT_GOOGLE_ACT_STATUS = "google_active_status",
            TEXT_INTERVAL_MODE = "interval_mode", TEXT_INTERVAL_LIMIT = "interval_limit",
            TEXT_INTERVAL_MODE_FIXED = "fixed", TEXT_INTERVAL_MODE_RANDOM = "random";

    public SettingValues() {
        facebookUser = new User();
        googleUser = new User();
        twitterUser = new User();

        facebookUser.setType(User.TEXT_FACEBOOK);
        googleUser.setType(User.TEXT_GOOGLE);
        twitterUser.setType(User.TEXT_TWITTER);
    }

    /**
     * @return the startup
     */
    public boolean isStartup() {
        return startup;
    }

    /**
     * @param startup the startup to set
     */
    public void setStartup(boolean startup) {
        this.startup = startup;
    }

    /**
     * @return the dataUser
     */
    public User getDataUser() {
        return dataUser;
    }

    /**
     * @param dataUser the dataUser to set
     */
    public void setDataUser(User dataUser) {
        this.dataUser = dataUser;
    }

    /**
     * @return the modeInterval
     */
    public String getModeInterval() {
        return modeInterval;
    }

    /**
     * @param modeInterval the modeInterval to set
     */
    public void setModeInterval(String modeInterval) {
        this.modeInterval = modeInterval;
    }

    /**
     * @return the limitInterval
     */
    public int getLimitInterval() {
        return limitInterval;
    }

    /**
     * @param limitInterval the limitInterval to set
     */
    public void setLimitInterval(int limitInterval) {
        this.limitInterval = limitInterval;
    }

    /**
     * @return the copyrightMessage
     */
    public String getCopyrightMessage() {
        return copyrightMessage;
    }

    /**
     * @param copyrightMessage the copyrightMessage to set
     */
    public void setCopyrightMessage(String copyrightMessage) {
        this.copyrightMessage = copyrightMessage;
    }

    /**
     * @return the facebookProfileActive
     */
    public boolean isFacebookProfileActive() {
        return facebookProfileActive;
    }

    /**
     * @param facebookProfileActive the facebookProfileActive to set
     */
    public void setFacebookProfileActive(boolean facebookProfileActive) {
        this.facebookProfileActive = facebookProfileActive;
    }

    /**
     * @return the twitterProfileActive
     */
    public boolean isTwitterProfileActive() {
        return twitterProfileActive;
    }

    /**
     * @param twitterProfileActive the twitterProfileActive to set
     */
    public void setTwitterProfileActive(boolean twitterProfileActive) {
        this.twitterProfileActive = twitterProfileActive;
    }

    /**
     * @return the googleProfileActive
     */
    public boolean isGoogleProfileActive() {
        return googleProfileActive;
    }

    /**
     * @param googleProfileActive the googleProfileActive to set
     */
    public void setGoogleProfileActive(boolean googleProfileActive) {
        this.googleProfileActive = googleProfileActive;
    }

    /**
     * @return the facebookUser
     */
    public static User getFacebookUser() {
        return facebookUser;
    }

    /**
     * @param facebookUser the facebookUser to set
     */
    public static void setFacebookUser(User fb) {
        facebookUser = fb;
    }

    /**
     * @return the twitterUser
     */
    public static User getTwitterUser() {
        return twitterUser;
    }

    /**
     * @param twitterUser the twitterUser to set
     */
    public static void setTwitterUser(User tw) {
        twitterUser = tw;
    }

    /**
     * @return the googleUser
     */
    public static User getGoogleUser() {
        return googleUser;
    }

    /**
     * @param googleUser the googleUser to set
     */
    public static void setGoogleUser(User gg) {
        googleUser = gg;
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

    public String getDBSettingValues() {

        String columns = null;

        columns = TEXT_WINDOWS_STARTUP + "=?," + TEXT_COPYRIGHT_MESSAGE + "=?,"
                + TEXT_INTERVAL_MODE + "=?," + TEXT_INTERVAL_LIMIT + "=?";

        return columns;

    }

}
