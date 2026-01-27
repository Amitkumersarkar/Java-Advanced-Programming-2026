class Shape
{
    double getArea()
    {
        return 0;
    }

    double getPerimeter()
    {
        return 0;
    }
}

class Circle extends Shape
{
    double r = 5;

    double getArea()
    {
        return 3.14 * r * r;
    }

    double getPerimeter()
    {
        return 2 * 3.14 * r;
    }

    public static void main(String args[])
    {
        Circle c = new Circle();
        System.out.println("Area = " + c.getArea());
        System.out.println("Perimeter = " + c.getPerimeter());
    }
}
