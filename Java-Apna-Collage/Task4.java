public class Task4 {
    int modelYear;
    String modelName;

    public Task4(int year, String name){
        modelYear=year;
        modelName=name;
    }
    public static void main(String[] args){
        Task4 car=new Task4(1999,"Audi");
        System.out.println(car.modelYear+" "+car.modelName);
    }
}
