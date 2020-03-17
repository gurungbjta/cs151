import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This program implements an animation that moves
 * a car shape.
 */
public class AnimationTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
        MoveableShape shape2 = new CarShape(0, 5, CAR_WIDTH); // creating a second car

        ArrayList<MoveableShape> shapes = new ArrayList<>(); // arraylist of cars
        shapes.add(shape);
        shapes.add(shape2);

        ArrayList<ShapeIcon> icons = new ArrayList<>(); // arraylist of icons
        for (MoveableShape s : shapes) {
            ShapeIcon icon = new ShapeIcon(s, ICON_WIDTH, ICON_HEIGHT);
            icons.add(icon);
        }

        ArrayList<JLabel> labels = new ArrayList<>(); // arraylist of labels
        for (ShapeIcon icon : icons) {
            JLabel label = new JLabel(icon);
            labels.add(label);
            frame.setLayout(new FlowLayout());
            frame.add(label);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks

        Timer t = new Timer(DELAY, event ->
        {
            int i = 0;
            for (MoveableShape s : shapes) { //go through each car in shapes
                s.move();
                labels.get(i).repaint(); // repaint the label associated with each car
                i++;
            }

        });
        t.start();
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
}

