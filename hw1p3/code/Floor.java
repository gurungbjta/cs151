import java.util.ArrayList;

public class Floor {
    private ArrayList<ArrayList> availableSeats;
    private final int DISCOUNT_NIGHT_PRICE = 20;
    private int groupDiscountPrice;

    public Floor() {
        groupDiscountPrice = 2;
        availableSeats = new ArrayList<>();
    }

    public int getCapacity(int min, int max) {
        return min + max;
    }

    public int getGroupDiscountPrice() {
        return groupDiscountPrice;
    }

    public int getDISCOUNT_NIGHT_PRICE() {
        return DISCOUNT_NIGHT_PRICE;
    }

    public boolean checkAvailability(ArrayList arr, ArrayList available) {
        boolean flag = true;
        ArrayList notAvailable = new ArrayList();
        for (Object o : arr) {
            if (!available.contains(o)) {
                notAvailable.add(o);
                flag = false;
            }
        }
        if (flag) {
            return true;
        } else {
            System.out.println("These are not available: " + notAvailable);
            return false;
        }
    }

    public void addAv(ArrayList av) {
        availableSeats.add(av);
    }

    public ArrayList getAvailableSeats() {
        return availableSeats;
    }

}
