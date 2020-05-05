public class Patient implements Hospital {
    private String name;
    private int age;
    private String occupation;
    private String gender;
    private String type;

    public Patient(String n, int a, String o, String g, String t) {
        this.name = n;
        this.age = a;
        this.occupation = o;
        this.gender = g;
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
        return "I am a " + type;
    }
}
