public class Employee implements Hospital {
    private String name;
    private int age;
    private String occupation;
    private String gender;
    private int id;
    private double salary;
    private String type;

    public Employee(String n, int a, String o, String g, int id, double s, String t) {
        this.name = n;
        this.age = a;
        this.occupation = o;
        this.gender = g;
        this.id = id;
        this.salary = s;
        this.type = t;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String description() {
        return "I am " + type;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }


}
