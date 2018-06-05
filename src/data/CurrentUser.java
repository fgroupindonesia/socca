package data;

import beans.Account;
import executors.FB;
import executors.GG;
import executors.TW;
import java.util.ArrayList;
import java.util.Timer;

/**
 * This Class is made for all frames usage
 * having several data access such as User, Timer, and Execution
 * @author @FgroupIndonesia.com
 */
public class CurrentUser {

    public static User Data;
    public static boolean stopExecution = true;
    private static ArrayList<Timer> dataExecution = new ArrayList<Timer>();
    public static boolean accountGoogleLoggedIn=false;
    public static boolean accountFacebookLoggedIn=false;
    public static boolean accountTwitterLoggedIn=false;
    public static FB FacebookPoster = new FB();
    public static TW TwitterPoster = new TW();
    public static GG GooglePoster = new GG();
    public static Account AkunFB = new Account();
    public static Account AkunGG = new Account();
    public static Account AkunTW = new Account();
    public static String LastLocationBrowsePicture = null;

    public static void stopAllExecution() {
        for (Timer t : dataExecution) {
            t.cancel();
            t.purge();
        }
        
        dataExecution.clear();
    }
    
    public static void addExecution(Timer objectIn){
        dataExecution.add(objectIn);
    }
}
