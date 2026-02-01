import java.util.Arrays;
public class ArrayLen {
    public static void main(String[] args){
        int physics=90;
        int chem=85;
        int eng=95;
        int[] marks=new int[3];
        marks[0]=90;
        marks[1]=85;
        marks[2]=95;
//        System.out.println(marks.length);
//        sorts in java
        System.out.println(marks[0]);
        Arrays.sort(marks);
        System.out.println(marks[0]);
    }
}
