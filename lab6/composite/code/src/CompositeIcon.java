import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompositeIcon implements Icon {
    private ArrayList<Icon> icons;

    public CompositeIcon() {
        icons = new ArrayList<>(); // array of icons
    }

    public void addIcon(Icon icon) {
        icons.add(icon);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        int i = 1;
        for (Icon icon : icons) {
            icon.paintIcon(c, g, x, y);
            x = x + (i * icon.getIconWidth()); // paint the next icon right next to the previous icon
            i++;
        }
    }

    @Override
    public int getIconWidth() {
        int totalWidth = 0;
        for (Icon icon : icons) {
            totalWidth += icon.getIconWidth(); // all the widths of the icons in the arraylist
        }
        return totalWidth;
    }

    @Override
    public int getIconHeight() {
        int totalHeight = 0;
        for (Icon icon : icons) {
            totalHeight += icon.getIconWidth(); // all the heights of the icons in the arraylist
        }
        return totalHeight;
    }
}
