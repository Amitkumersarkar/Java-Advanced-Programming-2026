import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class CellButton extends JButton {

    private char value = ' ';

    public CellButton() {
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(Theme.CELL);
    }

    public void setValue(char v) {
        value = v;
        repaint();
    }

    private void glow(Graphics2D g2, Shape s, Color c) {
        for (int i = 10; i >= 2; i -= 2) {
            g2.setStroke(new BasicStroke(i));
            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 30));
            g2.draw(s);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (value == 'X') {
            Shape l1 = new Line2D.Float(20,20,getWidth()-20,getHeight()-20);
            Shape l2 = new Line2D.Float(getWidth()-20,20,20,getHeight()-20);

            glow(g2,l1,Theme.NEON_PINK);
            glow(g2,l2,Theme.NEON_PINK);

            g2.setStroke(new BasicStroke(4));
            g2.setColor(Theme.NEON_PINK);
            g2.draw(l1);
            g2.draw(l2);

        } else if (value == 'O') {
            Shape c = new Ellipse2D.Float(20,20,getWidth()-40,getHeight()-40);

            glow(g2,c,Theme.NEON_BLUE);

            g2.setStroke(new BasicStroke(4));
            g2.setColor(Theme.NEON_BLUE);
            g2.draw(c);
        }
    }
}