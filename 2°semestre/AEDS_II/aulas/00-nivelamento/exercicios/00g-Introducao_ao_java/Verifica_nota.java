//QUESTAO 17

import java.util.Scanner;

public class Verifica_nota {
    public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);

    int nota;
    nota = scanner.nextInt();

    if(nota >= 80) System.out.println("Parabens, muito bom!");
    else if(nota >= 70) System.out.println("Parabens, aprovado");
    else System.out.println("Reprovado");






    scanner.close();
    }
}
