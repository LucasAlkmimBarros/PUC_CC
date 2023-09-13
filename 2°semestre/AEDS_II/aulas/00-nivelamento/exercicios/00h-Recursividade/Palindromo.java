//QUESTAO 26

import java.util.Scanner;

public class Palindromo {

    public static boolean conferePalindromo(String str, int a, int b){
        boolean ehPalindromo;
        if(a >= b){
            ehPalindromo = true;
        }
        else if(str.charAt(a) != str.charAt(b-1)){
            ehPalindromo = false;
        }
        else{
            ehPalindromo = conferePalindromo(str, a+1, b-1);
        }
        return ehPalindromo;
    }

    public static void main(String Args[]){
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        if(conferePalindromo(str, 0, str.length())){
            System.out.println("é palindromo");
        }
        else{
             System.out.println("não é palindromo");
        }

        scanner.close();
    }
}
