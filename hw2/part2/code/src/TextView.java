import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TextView extends Box implements Observer {
    private JTextField field;
    private DataModel model;
    private GraphView graphView;
    private final int FIELD_WIDTH = 10;
    ArrayList<JTextField> fields;


    //    /**
//     * Creates a <code>Box</code> that displays its components
//     * along the the specified axis.
//     *
//     * @param axis can be {@link BoxLayout#X_AXIS},
//     *             {@link BoxLayout#Y_AXIS},
//     *             {@link BoxLayout#LINE_AXIS} or
//     *             {@link BoxLayout#PAGE_AXIS}.
//     * @throws AWTError if the <code>axis</code> is invalid
//     * @see #createHorizontalBox
//     * @see #createVerticalBox
//     */
    public TextView(DataModel aModel) {
        super(BoxLayout.Y_AXIS);
        model = aModel;
        field = new JTextField(FIELD_WIDTH);
        fields = new ArrayList<>(); // arrayList of all JTextFields
    }

    public void setModel(DataModel m) {
        this.model = m;
    }

    public void setField() {
        graphView = new GraphView();
        ArrayList items = model.getItems();
        for (int i = 0; i < items.size(); i++) {
            field = new JTextField(FIELD_WIDTH); // create JTextFields for every item in the model array
            String text = items.get(i).toString();
            field.setText(text); // set the JTextFields the item of the model arrayList
            fields.add(field);
            int finalI = i;
            field.getDocument().addDocumentListener(new DocumentListener() { // activate documentListener for every field

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("Insert update");
                    String newText = fields.get(finalI).getText(); //fetching the new text from text field
                    System.out.println("new text " + newText);
                    model.getItems().set(finalI, newText); //setting a new text by changing model
                    System.out.println("model: " + model.getItems());
                    model.dataChange(model.getItems()); //notifying all observers of model
                    graphView.update(model, model.getItems()); // updating the graphView accordingly
                    update(model, model.getItems()); // updating itself
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println("Remove update");
                    String newText = fields.get(finalI).getText();
                    try {
                        if (!newText.isEmpty()) { // only change if the new text is not empty
                            model.getItems().set(finalI, newText);
                            model.dataChange(model.getItems());
                            graphView.update(model, model.getItems());
                            update(model, model.getItems());

                        }
                    } catch (NumberFormatException exception) {
                        System.out.println("Exception");
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    model.dataChange(model.getItems());
                }
            });
            super.add(field);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        for (int i = 0; i < this.getComponents().length; i++) { // iterate over each component
            JTextField f = (JTextField) this.getComponents()[i]; // casting it to JTextField
            if (!f.getText().equals(model.getItems().get(i))) { // if the text in textField is different than in the model, update the textField
                f.setText(model.getItems().get(i).toString());
            }
        }
    }
}
