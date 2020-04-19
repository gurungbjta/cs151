import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Observable;

public class DataModel extends Observable {
    private ArrayList arr; // arrayList of items from file
    private ArrayList<ChangeListener> listeners;

    public DataModel() {
        arr = new ArrayList();
        listeners = new ArrayList<>();
    }

    public void addItems(String n) {
        arr.add(n);
        dataChange(new TextView(new DataModel())); // notify textView
        dataChange(new GraphView()); // notify graphView
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(event);
        }
    }

    public void dataChange(Object data) {
        setChanged();
        notifyObservers(data);
    }

    public ArrayList getItems() {
        return arr;
    }


}
