import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GraphView extends JPanel implements Observer {
    DataModel model;
    private int x;
    private int y;
    private static final int HEIGHT = 20;

    public GraphView() {
        x = 0;
        y = 0;
        model = new DataModel();
    }

    public void setModel(DataModel m) {
        this.model = m;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        ArrayList items = model.getItems();
        Rectangle rec;
        for (int i = 0; i < items.size(); i++) {
            String s = items.get(i).toString(); // converting object to string type
            int item = Integer.parseInt(s); // converting string to integer type
            rec = new Rectangle(x, y + (i * HEIGHT), item, HEIGHT); // compose rectangle for each bar
            g2.setColor(Color.RED); // setting color as red for fun
            g2.draw(rec); // draw the rectangle
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint(); // call the paintComponent method to repaint
    }
}
