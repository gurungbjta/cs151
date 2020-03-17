import javax.swing.*;
import java.awt.*;

/**
 * This program implements an animation that moves
 * a car shape.
 */
public class AnimationTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        MoveableShape ball = new BouncingBall(0, 0, BALL_WIDTH);

        ShapeIcon icon = new ShapeIcon(ball,
                ICON_WIDTH, ICON_HEIGHT);

        JLabel label = new JLabel(icon);
        frame.setLayout(new FlowLayout());
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, event ->
        {
            ball.move();
            label.repaint();
        });
        t.start();
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int BALL_WIDTH = 50;
}
