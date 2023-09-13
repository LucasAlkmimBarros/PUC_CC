//QUESTAO 24

import java.util.Scanner;

public class Multiplicacao_somando {

    public static int multiplica(int num1, int num2){
        int resp = 0;
        
        if(num1 > 0){
            resp = num2 + multiplica((num1-1), num2);
        }

        return resp;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int num1, num2;
        System.out.println("Digite o primeiro valor: ");
        num1 = scanner.nextInt();
        System.out.println("Digite o segundo valor: ");
        num2 = scanner.nextInt();

        int resp = multiplica(num1, num2);
        System.out.print(num1 +" X "+ num2 + " = " +resp);

        scanner.close();
    }
}
