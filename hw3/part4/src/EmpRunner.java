import java.util.ArrayList;
import java.util.Collections;

public class EmpRunner {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Collin", 1));
        employees.add(new Employee("Mary", 2));
        employees.add(new Employee("Amber", 3));

        ArrayList<Employee> deepcopy = new ArrayList<>();
        for (Employee e : employees) { // deep copy of employees
            deepcopy.add(e.clone());
        }
//
//        ArrayList<Employee> deepcopy = (ArrayList<Employee>) employees.clone();

        Collections.sort(deepcopy, new EmpCompByName()); // sort by name
        for (Employee e : deepcopy) {
            System.out.println(e.getName());
        }
    }
}
