import java.util.Scanner;

class Complex
{
    int r, i;

    Complex(int r, int i)
    {
        this.r = r;
        this.i = i;
    }

    Complex add(Complex c)
    {
        return new Complex(r + c.r, i + c.i);
    }

    void show()
    {
        System.out.println("Sum = " + r + " + " + i + "i");
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter real and imaginary numbers respectively: ");
        int r1 = sc.nextInt();
        int i1 = sc.nextInt();

        System.out.print("Enter real and imaginary numbers respectively: ");
        int r2 = sc.nextInt();
        int i2 = sc.nextInt();

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        Complex result = c1.add(c2);
        result.show();
    }
}
