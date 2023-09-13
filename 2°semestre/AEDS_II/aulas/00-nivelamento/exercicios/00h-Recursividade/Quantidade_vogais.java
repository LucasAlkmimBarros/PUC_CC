//QUESTAO 27

import java.util.Scanner;

public class Quantidade_vogais {

    public static int calculaVogais(String str, int n){
        int qtVogal = 0;
        if(n == 0){
            return qtVogal;
        }
        else{
            if(str.charAt(n-1) == 'A' || str.charAt(n-1) == 'E' || str.charAt(n-1) == 'I' || str.charAt(n-1) == 'O' || str.charAt(n-1) == 'U'){
                qtVogal++;
            }
            
            qtVogal += calculaVogais(str, n-1);
        }

        return qtVogal;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a palavra: ");
        String str = scanner.nextLine();
        str = str.toUpperCase();

        int quantidadeVogais = calculaVogais(str, str.length());
    
        System.out.println("A quantidade de vogais é: " + quantidadeVogais);
    
        scanner.close();
    }
}
