class Employee
{
    double salary = 50000;

    double bonus()
    {
        return salary * 0.10;
    }
}

class Manager extends Employee
{
    double bonus()
    {
        return salary * 0.20;
    }

    public static void main(String args[])
    {
        Manager m = new Manager();
        System.out.println("Bonus : " + m.bonus());
    }
}
