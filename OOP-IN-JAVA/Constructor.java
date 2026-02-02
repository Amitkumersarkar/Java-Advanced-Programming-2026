class Student{
    String name;
    int id;
    public void studentInfo(){
        // System.out.println("He is the CSE undergrad student");
        System.out.println(this.name);
        System.out.println(this.id);

    }
}
public class Constructor {
public static void main(String[] args) {
    Student s1=new Student();
    s1.name="Amit";
    s1.id=283;
    s1.studentInfo();

}
    
}
