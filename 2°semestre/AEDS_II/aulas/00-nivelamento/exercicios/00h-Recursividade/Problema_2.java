//QUESTAO 29

public class Problema_2 {
    public static int problema_2(int n){
        if(n == 0) return 1;
        else{
            return (int) Math.pow(problema_2(n - 1), 2);
        }
    }
}
