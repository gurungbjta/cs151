import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FIELD_WIDTH = 20;
        JTextField textField = new JTextField(FIELD_WIDTH);
        textField.setText("Click a button!");

        JButton helloButton = new JButton("Say Hello");
        JButton goodbyeButton = new JButton("Say Goodbye");

        final int[] helloCount = {1};
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Hello " + helloCount[0]);
                helloCount[0] = helloCount[0] + 1; // incrementing by 1 after every hello button
            }
        });

        final int[] goodbyeCount = {1};
        goodbyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Goodbye " + goodbyeCount[0]);
                goodbyeCount[0] = goodbyeCount[0] + 1; // incrementing by 1 after every goodbye button
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(helloButton);
        frame.add(goodbyeButton);
        frame.add(textField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
