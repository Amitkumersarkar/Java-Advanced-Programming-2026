class Pen{
    // bluePrint
String color;
String type;

// Declared a method
public void write(){
    System.out.println("writing something");

}
public void printColor(){
    // The this keyword in Java refers to the current object in a method or constructor.
    System.out.println(this.color);

}
}

public class OOPS {
    public static void main(String[] args) {
        // create objects of the pen
        Pen p1=new Pen();
        p1.color="Red"; //assign a color
        p1.type="Gel"; //assign type

        //create a new object
Pen p2=new Pen();
p2.color="Blue";
p2.type="BallPoint";
        //here call the function/method
        p1.write();
p1.printColor();
p2.printColor();
    }
}
