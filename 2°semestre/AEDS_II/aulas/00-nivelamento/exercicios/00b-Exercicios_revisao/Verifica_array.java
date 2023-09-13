//QUESTAO 1

import java.util.Scanner;


public class Verifica_array {
    public static final int TAM = 5;

    public boolean verificandoArray(int[] array, int valorVerificado){
        boolean temValor = false;
        for(int i = 0; i < TAM; i++){
            if(valorVerificado == array[i]) temValor = true;
        }

        return temValor;
    }


    public static void main(String[] args){
        int[] array = new int[TAM];
        Scanner scanner = new Scanner(System.in);
        int valorVerificado;

        for(int i = 0; i < TAM; i++){
            System.out.println("Valor do " + (i+1) +  ".o elemento do array: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Agora digite o valor que deseja verificar: ");
        valorVerificado = scanner.nextInt();


        Verifica_array verifica_array = new Verifica_array();
        if(verifica_array.verificandoArray(array, valorVerificado)){
            System.out.println("Tem valor!");
        }
        else{
            System.out.println("Nao tem valor!");
        }

        scanner.close();
    }
}
