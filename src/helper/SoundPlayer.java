package helper;

import configuration.ConfigReader;
import configuration.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class SoundPlayer {

    public static final int POP_FILE = 1, HORRAY_FILE = 2, TICKTOCK_FILE = 3;
    private static String popFileName = "pop.wav", horrayFileName = "horray.wav",
            ticktockFileName = "ticktock.wav";

    private static String filePilihan = null;

    @SuppressWarnings("deprecation")
    public static void play(int fileType) {

        try {
            if (fileType == POP_FILE) {
                filePilihan = ConfigReader.getSystemPath() + "\\" + popFileName;
            } else if (fileType == TICKTOCK_FILE) {
                filePilihan = ConfigReader.getSystemPath() + "\\" + ticktockFileName;
            } else {
                filePilihan = ConfigReader.getSystemPath() + "\\" + horrayFileName;
            }

            InputStream in = new FileInputStream(filePilihan);

            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception ex) {
            String pesan = "Error play()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);

        }

    }

}
