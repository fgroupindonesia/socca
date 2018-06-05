package helper.ui;

import data.CurrentUser;
import frames.internal.Dashboard;
import helper.SoundPlayer;
import java.util.Currency;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author @FgroupIndonesia.com
 */
public class TimerEffect extends SwingWorker<Object, Object> {

    private JLabel targetLabel;
    private int limitInterval = 0;
    private int numberMin = 0, numberSec = 59;
    private String endOutput = null, textMinute, textSecond;
    private boolean audioPlayed = false;

    @Override
    protected Object doInBackground() throws Exception {

        while (CurrentUser.stopExecution != true) {

            // numberMin is actually limitInterval-1
            renderTime();

            // decrease every seconds
            if (numberSec > 0) {
                numberSec--;
            }

            Thread.sleep(1000);

            if (numberMin == 0 && numberSec <= 5) {
                Dashboard.writeToConsole("ready to launched within... " + numberSec);
                if (audioPlayed == false) {
                    SoundPlayer.play(SoundPlayer.TICKTOCK_FILE);
                }
                // makesure its just running once
                audioPlayed = true;
            }

            if (numberMin == 0 && numberSec == 0) {
                Dashboard.writeToConsole("Wait a moment...");
            }

            if (numberSec == 0) {
                if (numberMin > 0) {
                    numberMin--;

                    // seconds returned back to 59
                    numberSec = 59;
                }
            }

            if (numberSec == 0 && numberMin == 0) {
                renderTime();
                break;
            }

        }

        resetTime();

        return null;
    }

    private void resetTime() {

        textMinute = getDigit(0);
        textSecond = getDigit(0);
        endOutput = "Timer : " + textMinute + ":" + textSecond;
        this.getTargetLabel().setText(endOutput);
    }

    private void renderTime() {

        textMinute = getDigit(numberMin);
        textSecond = getDigit(numberSec);
        endOutput = "Timer : " + textMinute + ":" + textSecond;
        this.getTargetLabel().setText(endOutput);
    }

    private String getDigit(int numIn) {
        if (numIn < 10) {
            return 0 + "" + numIn;
        } else if (numIn > 59) {
            return "00";
        }

        return "" + numIn;
    }

    /**
     * @return the targetLabel
     */
    public JLabel getTargetLabel() {
        return targetLabel;
    }

    /**
     * @param targetLabel the targetLabel to set
     */
    public void setTargetLabel(JLabel targetLabel) {
        this.targetLabel = targetLabel;
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

        this.numberMin = limitInterval - 1;
    }
}
