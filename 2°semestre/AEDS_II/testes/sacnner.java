import java.util.*;

public class sacnner {
    public static void main(String[] args){
        int[] num = new int[5];
        for(int i = 0; i < num.length; i++){
            num[i] = i*4;
        }
        for(int i = 0; i < num.length; i++){
            System.out.println(num[i]);
        }
        System.out.println(num.length);
       
    }
}
