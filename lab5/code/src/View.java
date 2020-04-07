import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private final JTextArea textArea = new JTextArea(20, 20);
    private final JTextField textField = new JTextField(10);
    private final JButton addButton = new JButton("Add");

    public View() {
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 300);

        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.SOUTH);
        panel.add(addButton, BorderLayout.NORTH);
        this.add(panel);
    }

    public void setTextArea(String text) {
        textArea.setText(text);
    }

    public String getTextField() {
        return textField.getText();
    }

    public void setAddButton(ActionListener listener) {
        addButton.addActionListener(listener);
    }

}
