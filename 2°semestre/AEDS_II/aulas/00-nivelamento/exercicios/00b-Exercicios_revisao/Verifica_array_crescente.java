//QUESTAO 2


import java.util.Scanner;


public class Verifica_array_crescente {
    public static final int TAM = 5;

    public boolean verificandoArray(int[] array, int valorVerificado){
        boolean temValor = false;
        if(valorVerificado > array[array.length/2]){
            for(int i = array.length/2; i < array.length; i++){
                if(valorVerificado == array[i]) temValor = true;
            }
        }
        else{
            for(int i = 0; i <= array.length/2; i++){
                if(valorVerificado == array[i]) temValor = true;
            }
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


        Verifica_array_crescente Verifica_array_crescente = new Verifica_array_crescente();
        if(Verifica_array_crescente.verificandoArray(array, valorVerificado)){
            System.out.println("Tem valor!");
        }
        else{
            System.out.println("Nao tem valor!");
        }

        scanner.close();
    }
}
