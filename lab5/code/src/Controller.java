import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
        this.view.setAddButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = view.getTextField();
                model.addItem(item);

                String prev = "";
                for (Object o : m.getItems()) {
                    String s = (String) o;
                    prev += " " + s + "\n";
                    view.setTextArea(prev);
                }
            }
        });
    }
}
