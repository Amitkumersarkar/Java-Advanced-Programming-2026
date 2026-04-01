public class Task3 {
    public void fullThrottle(){
        System.out.println("the car is going as fast as it can !");

    }
public void speed(int maxSpeed){
    System.out.println("Max speed is :"+maxSpeed);

}

public static void main(String[] args){
    Task3 car=new Task3();
    car.fullThrottle();
    car.speed(200);
}
}
