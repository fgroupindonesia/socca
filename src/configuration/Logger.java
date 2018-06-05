
package configuration;

import javax.swing.JOptionPane;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class Logger {
    
    private int nomorError=0;
    private String dcontent;
    
    public static void showMessage(String dmessage){
        JOptionPane.showMessageDialog(null, dmessage);
    }
    
    
}
