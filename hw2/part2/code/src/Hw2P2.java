import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Hw2P2 {
    public static void main(String[] args) throws IOException {
        DataModel model = new DataModel();
        TextView tv = new TextView(model);
        GraphView gv = new GraphView();
        model.addObserver(tv); // adding tv as observer to model
        model.addObserver(gv); // adding gv as observer to model

        String line;
        BufferedReader br = new BufferedReader(new FileReader(args[0])); // getting file from args[0] to read
        while ((line = br.readLine()) != null) { // read and add line to model from the file until there is no line to read
            model.addItems(line);
        }
        tv.setModel(model);
        tv.setField();

        gv.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                int x = event.getX(); // x point of the mouse
                int y = event.getY(); // y point of the mouse

//                int newY = (y / 10) * 10;
                int newY = y - (y % 20); //getting the next smallest item from the array

                for (int i = 0; i < model.getItems().size(); i++) {
                    String s = model.getItems().get(i).toString();
                    if (Integer.parseInt(s) == newY) {
                        model.getItems().set(i, x); // set the ith item in the array as x of the mouse
                        model.dataChange(model.getItems());
                        gv.update(model, model.getItems()); // update itself
                        tv.update(model, model.getItems()); // update the textView accordingly
                    }
                }
            }
        });

        JFrame frame = new JFrame(); // creating frame1
        frame.setSize(800, 200);
        frame.setContentPane(tv);
        frame.addWindowListener(new WindowAdapter() { // if this frame closes, save all data to a new file
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter(args[1]));
                    for (Object o : model.getItems()) {
                        pw.println(o);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.pack();

        JFrame frame2 = new JFrame(); // creating frame2

        gv.setModel(model);
        frame2.setSize(400, 200);
        frame2.setContentPane(gv);
        frame2.setBounds(200, 0, 400, 400);
        frame.setVisible(true);
        frame2.setVisible(true);
        frame2.addWindowListener(new WindowAdapter() { // if this frame closes, save all data to a new file
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter(args[1]));
                    for (Object o : model.getItems()) {
                        pw.println(o);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
