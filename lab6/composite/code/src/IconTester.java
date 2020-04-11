import javax.swing.*;

public class IconTester {
    public static void main(String[] args) {
        Icon compositeIcon = new CompositeIcon();
        ((CompositeIcon) compositeIcon).addIcon(new MarsIcon(50));
        ((CompositeIcon) compositeIcon).addIcon(new ImageIcon("globe.gif"));

        JOptionPane.showMessageDialog(
                null,
                "Hello, Composite!",
                "Message",
                JOptionPane.INFORMATION_MESSAGE,
                compositeIcon);
        System.exit(0);
    }
}
