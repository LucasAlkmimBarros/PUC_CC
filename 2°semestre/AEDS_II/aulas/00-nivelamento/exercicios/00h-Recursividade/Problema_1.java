//QUESTAO 28


public class Problema_1 {
    public static int problema_1(int n){
        if(n == 0) return 1;
        else if(n == 1) return 2;
        else{
            return problema_1(n-1) * problema_1(n-2) - problema_1(n-1);
        }

    }
}
