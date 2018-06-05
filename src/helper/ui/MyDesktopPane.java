/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper.ui;

import configuration.Logger;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JDesktopPane;

/**
 *
 * @author Martinus Ady H <mrt.itnewbies@gmail.com>
 */
public class MyDesktopPane extends JDesktopPane {

    private Image image;

    public MyDesktopPane() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            image = new javax.swing.ImageIcon(getClass().getResource("/frames/images/bg.png")).getImage();

            if (g != null) {
                Graphics2D g2d = (Graphics2D) g;

                //scale the image to fit the size of the Panel
                double mw = image.getWidth(null);
                double mh = image.getHeight(null);

                double sw = getWidth() / mw;
                double sh = getHeight() / mh;

                g2d.scale(sw, sh);
                g2d.drawImage(image, 0, 0, this);
            }
        } catch (Exception ex) {
            String pesan = "Error paintComponent()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
        }
    }
}
