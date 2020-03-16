import java.util.TreeMap;

public class Account {
    private TreeMap<String, String> map;

    public Account() {
        map = new TreeMap<>();
    }

    public void signUp(String id, String password) {
        if (!map.containsKey(id)) {
            map.put(id, password);
        } else {
            System.out.println("The id is already taken");
        }
    }

    public boolean signIn(String id, String password) {
        if (checkUserID(id, password)) {
            return true;
        }
        return false;
    }

    public boolean checkUserID(String id, String password) {
        if (map.containsKey(id)) {
            String pw = map.get(id);
            if (pw.equals(password)) {
                return true;
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("Invalid ID");
        }
        return false;
    }

//    public TreeMap<String, String> display() {
//        return map;
//    }
}
