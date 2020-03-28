import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sequence<T> {
    private final int CAPACITY = 5;
    private T[] arr;
    private int N; //num of items

    public Sequence() {
        this.arr = (T[]) new Object[CAPACITY];
        N = 0; // intially there are no items in the array
    }

    public Iterator<T> getItems() {
        return new ItemIterator();
    }


    private class ItemIterator implements Iterator<T> {
        private int current;

        ItemIterator() {
            current = 0;
        }

        public boolean hasNext() { // returns true if the item is not null
            if (arr[current] != null) {
                return true;
            }
            return false;
        }

        public T next() { // returns the item
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                T currItem = arr[current];
                current++;
                return currItem;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}


