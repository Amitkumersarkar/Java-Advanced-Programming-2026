class Student {
    int id;
    String name;
    double cgpa;

    Student(int i, String n, double c) {
        id = i;
        name = n;
        cgpa = c;
    }

    void display() {
        System.out.println(id + " | " + name + " | " + cgpa);
    }
}

class Department {
    Student[] students = new Student[5];
    int count = 0;

    void register(Student s) {
        if (count < students.length) {
            students[count++] = s;
        } else {
            System.out.println("No more space!");
        }
    }

    void search(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                students[i].display();
                return;
            }
        }
        System.out.println("Student not found");
    }

    void displayAll() {
        for (int i = 0; i < count; i++)
            students[i].display();
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        Department d = new Department();

        d.register(new Student(1, "Amit", 3.20));
        d.register(new Student(2, "Rafi", 3.50));

        d.search(2);
        d.displayAll();
    }
}
