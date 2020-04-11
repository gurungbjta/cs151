import javax.swing.*;
import java.awt.*;

// Implement a decorator BoxedIcon that draws a box outside an icon.
// Leave a ten pixel gap between the original icon and the lines that you draw around it.

public class BoxedIcon implements Icon {
    private final int GAP = 10; // gap between original icon and boxed icon
    private Icon icon; // the icon that we wanna draw box around

    public BoxedIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(x, y, getIconWidth(), getIconHeight()); // box outside the icon
        g2.draw(box);
        icon.paintIcon(c, g, x + GAP, y + GAP);
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth() + GAP + GAP; //width of original icon plus two gaps
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight() + GAP + GAP; //height of original icon plus two gaps
    }
}
