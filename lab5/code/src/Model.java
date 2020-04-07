import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Model {
    private ArrayList items;
    private ArrayList<ChangeListener> listeners;

    public Model() {
        items = new ArrayList();
        listeners = new ArrayList<>();
    }

    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public void addItem(String item) {
        items.add(item);
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(event);
        }
    }

    public ArrayList getItems() {
        return items;
    }

}
