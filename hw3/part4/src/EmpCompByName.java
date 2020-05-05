import java.util.Comparator;

public class EmpCompByName implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) { // compares employee by name
        return e1.getName().compareTo(e2.getName());
    }
}
