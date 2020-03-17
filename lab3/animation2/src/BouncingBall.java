import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BouncingBall implements MoveableShape {

    private int x;
    private int y;
    private int width;

    public BouncingBall(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void move() {

        int i = 1;

        if (y < 0 || (y + width) < 100) {
            x++;
            y += i;
//            i = 1;
        }
        if (y + width >= 100) {
            y -= i;
            x++;
        }

    }

    public void draw(Graphics2D g2) {
        Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, width, width);
        g2.draw(ellipse);
    }

}
