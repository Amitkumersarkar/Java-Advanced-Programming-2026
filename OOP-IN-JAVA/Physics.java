class Marks
{
    int roll = 283;
    String name = "Amit";
}

class Physics extends Marks
{
    int phy = 80;

    public static void main(String args[])
    {
        Physics p = new Physics();
        System.out.println("Roll : " + p.roll);
        System.out.println("Name : " + p.name);
        System.out.println("Physics Marks : " + p.phy);
    }
}
