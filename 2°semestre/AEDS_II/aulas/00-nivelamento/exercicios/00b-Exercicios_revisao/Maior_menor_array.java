//QUESTAO 3

import java.util.Scanner;

public class Maior_menor_array {
  
    public void imprimeMaiorMenor(int[] array){
        int maior = array[0];
        int menor = array[0];

        for(int i = 0; i < array.length; i++){
            if(array[i] > maior) maior = array[i];
        } //CALCULANDO O MAIOR

        for(int i = 0; i < array.length; i++){
            if(array[i] < menor) menor = array[i];
        } //CALCULANDO O MENOR

        System.out.println("O menor numero do array é: "+ menor);
        System.out.println("O maior numero do array é: "+ maior);
    }
  
  
    public static void main(String[] args){
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < array.length; i++){
            System.out.println("Digite o valor do "+(i +1)+".o valor: ");
            array[i] = scanner.nextInt();
        }

        Maior_menor_array maior_menor_array = new Maior_menor_array();
        maior_menor_array.imprimeMaiorMenor(array);


        scanner.close();
    }
}
