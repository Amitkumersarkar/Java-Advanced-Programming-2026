class Pen{
    // bluePrint
String color;
String type;

// Declared a method
public void write(){
    System.out.println("writing something");

}
}

public class OOPS {
    public static void main(String[] args) {
        // create objects of the pen
        Pen p1=new Pen();
        p1.color="Red"; //assign a color
        p1.type="Gel"; //assign type
        //here call the function/method
        p1.write();

    }
}
