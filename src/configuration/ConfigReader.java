package configuration;

import data.SettingValues;
import java.io.File;

/**
 * @author (c) www.fgroupindonesia.com
 */
public class ConfigReader {

    public static final String FILE_DATABASE = "database.db", FILE_SYSTEMLOG = "system.log",
            FOLDER_SYSTEM_NAME = "socca";

    public static final int FILE_INDEX_AGENT_BEGINNING = 1, FILE_INDEX_AGENT_ENDING = 7;

    private static File lokasi = null;

    public  static String getSystemPath() {
        String theOS = (System.getProperty("os.name")).toLowerCase();
        String thePath = null;

        if (theOS.contains("win")) {
            thePath = System.getenv("AppData");
        } else {
            // linux 
            thePath = System.getProperty("user.home");
        }

        thePath += "\\" + ConfigReader.FOLDER_SYSTEM_NAME;

        lokasi = new File(thePath);

        if (lokasi.exists() == false) {
            lokasi.mkdirs();

        }

        return thePath;
    }
    
    public static String getDBFilePath() {
        String theOS = (System.getProperty("os.name")).toLowerCase();
        String thePath = null;

        if (theOS.contains("win")) {
            thePath = System.getenv("AppData");
        } else {
            // linux 
            thePath = System.getProperty("user.home");
        }

        thePath += "\\" + ConfigReader.FOLDER_SYSTEM_NAME;

        lokasi = new File(thePath);

        if (lokasi.exists() == false) {
            lokasi.mkdirs();

        }

        thePath += "\\" + ConfigReader.FILE_DATABASE;

        return thePath;
    }

}
