class Vehicle
{
    int maxSpeed()
    {
        return 0;
    }
}

class Car extends Vehicle
{
    int maxSpeed()
    {
        return 180;
    }
}

class CarTest
{
    public static void main(String args[])
    {
        Car c = new Car();
        System.out.println("Car Max Speed : " + c.maxSpeed());
    }
}
