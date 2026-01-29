class Person
{
    String firstName = "Amit";
    String lastName = "Sarkar";

    String getLastName()
    {
        return lastName;
    }
}

class Employee extends Person
{
    int empId = 101;
    String jobTitle = "Developer";

    public static void main(String args[])
    {
        Employee e = new Employee();
        System.out.println("Employee : " + e.getLastName());
        System.out.println("Job Title : " + e.jobTitle);
    }
}
