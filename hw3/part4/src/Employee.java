public class Employee implements Cloneable {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee clone() { // returns clone of type Employee
        try {
            Employee cloned = (Employee) super.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null; // won't happen }
        }
    }

}
