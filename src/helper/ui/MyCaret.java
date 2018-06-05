package helper.ui;

import configuration.Logger;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

/**
 *
 * @author (c) www.fgroupindonesia.com
 */
public class MyCaret extends DefaultCaret {

    private String mark = "█";

    public MyCaret() {
        setBlinkRate(500);
    }

    @Override
    protected synchronized void damage(Rectangle r) {
        if (r == null) {
            return;
        }

        JTextComponent comp = getComponent();
        FontMetrics fm = comp.getFontMetrics(comp.getFont());
        int textWidth = fm.stringWidth(mark);
        int textHeight = fm.getHeight();
        x = r.x;
        y = r.y;
        width = textWidth;
        height = textHeight;
        repaint(); // calls getComponent().repaint(x, y, width, height)
    }

    @Override
    public void paint(Graphics g) {
        JTextComponent comp = getComponent();
        if (comp == null) {
            return;
        }

        int dot = getDot();
        Rectangle r = null;
        try {
            r = comp.modelToView(dot);
        } catch (BadLocationException ex) {
            String pesan = "Error paint()" + ex.getMessage();
            System.err.println(pesan);
            Logger.showMessage(pesan);
            return;
        }
        if (r == null) {
            return;
        }

        if ((x != r.x) || (y != r.y)) {
            repaint(); // erase previous location of caret
            damage(r);
        }

        if (isVisible()) {
            FontMetrics fm = comp.getFontMetrics(comp.getFont());

            g.setColor(comp.getCaretColor());
            g.drawString(mark, x, y + fm.getAscent());
        }
    }

}
