package data;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class PostEntry {

    private int id;
    private String title,
            message,
            socialMediaProfile,
            socialMediaProfileActive,
            attachmentFile,
            lastPosted,
            status;
    // these are all the columns used
    public static final String TEXT_ID = "id",
            TEXT_TITLE = "title",
            TEXT_MESSAGE = "message",
            TEXT_ATTACHMENT_FILE = "attachment_file",
            TEXT_LAST_POSTED = "last_posted",
            TEXT_SOCIAL_MEDIA_PROFILE = "social_media_profiles",
            TEXT_SOCIAL_MEDIA_PROFILE_ACTIVE = "social_media_profile_active",
            TEXT_STATUS = "status";

    // these are the values that might be used
    public static final String VALUE_STATUS_WAIT = "waiting",
            VALUE_STATUS_SUCCESS = "success",
            VALUE_STATUS_ERROR = "error",
            VALUE_SOCIAL_MEDIA_ALL = "all",
            VALUE_SOCIAL_MEDIA_SPECIFIC = "specific",
            VALUE_SOCIAL_MEDIA_FACEBOOK = "facebook",
            VALUE_SOCIAL_MEDIA_TWITTER = "twitter",
            VALUE_SOCIAL_MEDIA_GOOGLE = "google";

    public PostEntry() {

    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
     * @return the socialMediaProfile
     */
    public String getSocialMediaProfile() {
        return socialMediaProfile;
    }

    /**
     * @param socialMediaProfile the socialMediaProfile to set
     */
    public void setSocialMediaProfile(String socialMediaProfile) {
        this.socialMediaProfile = socialMediaProfile;
    }

    /**
     * @return the socialMediaProfileActive
     */
    public String getSocialMediaProfileActive() {
        return socialMediaProfileActive;
    }

    /**
     * @param socialMediaProfileActive the socialMediaProfileActive to set
     */
    public void setSocialMediaProfileActive(String socialMediaProfileActive) {
        this.socialMediaProfileActive = socialMediaProfileActive;
    }

    /**
     * @return the attachmentFile
     */
    public String getAttachmentFile() {
        return attachmentFile;
    }

    /**
     * @param attachmentFile the attachmentFile to set
     */
    public void setAttachmentFile(String attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    /**
     * @return the lastPosted
     */
    public String getLastPosted() {
        return lastPosted;
    }

    /**
     * @param lastPosted the lastPosted to set
     */
    public void setLastPosted(String lastPosted) {
        this.lastPosted = lastPosted;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDBValues() {
        String colomns = null;

        colomns = TEXT_TITLE + "=?," + TEXT_MESSAGE + "=?," + TEXT_ATTACHMENT_FILE + "=?,"
                + TEXT_SOCIAL_MEDIA_PROFILE + "=?," + TEXT_SOCIAL_MEDIA_PROFILE_ACTIVE + "=?,"
                + TEXT_STATUS + "=?," + TEXT_LAST_POSTED + "=?";

        return colomns;
    }

}
