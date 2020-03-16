import java.util.ArrayList;

public class LeftMainFloor extends Floor {
    private int price;
    private int total;
    private int minSeat;
    private int maxSeat;
    private ArrayList available;
    private ArrayList reserved;

    public LeftMainFloor() {
        super();
        price = 35;
        total = 0;
        minSeat = 1;
        maxSeat = 50;
        available = new ArrayList();
        for (int i = minSeat; i <= maxSeat; i++) {
            available.add(minSeat);
        }
        reserved = new ArrayList();
    }

    public ArrayList getAvailable() {
        return available;
    }

    public ArrayList getReserved() {
        return reserved;
    }

    public int getTotal() {
        return total;
    }

    public boolean isFull() {
        if (getCapacity(minSeat, maxSeat) == reserved.size()) {
            return true;
        }
        return false;
    }

    public void reserve(ArrayList arr) {
        if (!isFull()) {
            int numOfPeople = arr.size();
            if (checkAvailability(arr, available)) {
                for (Object o : arr) {
                    reserved.add(o);
                    available.remove(o);
                }
                total = price * numOfPeople;
            }
        }
    }

    public void cancel(ArrayList arr) {
        int prevTotal = getTotal();
        int numOfPeople = arr.size();
        if (checkAvailability(arr, reserved)) {
            for (Object o : arr) {
                available.add(o);
                reserved.remove(o);
            }
            total = prevTotal - (price * numOfPeople);
        }
    }
}
