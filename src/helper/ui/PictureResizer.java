package helper.ui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author @FgroupIndonesia.com
 */
public class PictureResizer {

    private static final int IMG_WIDTH = 220, IMG_HEIGHT = 160;
    
    public static BufferedImage resizeImagePreview(BufferedImage originalImage) {
        int jenisnya = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, jenisnya);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

}
