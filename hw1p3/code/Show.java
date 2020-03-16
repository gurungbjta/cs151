import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Show {
    private TreeMap<Date, ArrayList> dateMap;
    private ArrayList seats;
    private ArrayList<Floor> floor;

    public Show() {
        dateMap = new TreeMap<>();
        seats = new ArrayList<>();
        floor = new ArrayList<>();
    }

    public void add(Floor f) {
        floor.add(f);
    }

    public void addSeats() {
        for (Floor f : floor) {
            seats.add(f.getAvailableSeats());
        }

    }

    public void addInMap(Date d) {
        dateMap.put(d, seats);
    }


    public ArrayList displayAvailableSeats() {
        ArrayList availSeats = new ArrayList();
        for (Date k : dateMap.keySet()) {
            for (Object o : dateMap.get(k)) {
                availSeats.add(o);
            }
        }
        return availSeats;
    }


    public boolean checkAvailabiility(ArrayList arr) {
        boolean flag = true;
        ArrayList avSeats = displayAvailableSeats();
        ArrayList reserved = new ArrayList();
        for (int i = 0; i < arr.size(); i++) {
            if (!avSeats.contains(arr.get(i))) {
                reserved.add(arr.get(i));
                flag = false;
            }
        }
        if (!flag) {
            System.out.println("These seats are already reserved: " + reserved);
        }
        return flag;
    }


}
