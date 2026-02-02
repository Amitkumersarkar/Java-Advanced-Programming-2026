class Student {
    String name;
    int id;

    // parameterized constructor
    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void studentInfo() {
        System.out.println(this.name);
        System.out.println(this.id);
    }
}

public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student("Amit", 283);
        s1.studentInfo();
    }
}
