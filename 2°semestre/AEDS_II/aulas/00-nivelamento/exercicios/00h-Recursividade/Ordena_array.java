//QUESTAO 25

import java.util.Scanner;

public class Ordena_array {
    public static int[] array = new int[5];

    public static void swap(int a, int b){
        int aux = array[a];
        array[a] = array[b];
        array[b] = aux; 
    }


    public static void ordenaArray(int[] array, int n){
        if(n == 2){
            if(array[0] > array[1]){
                swap(0, 1);
            } 
        }
        else{
            for(int i = 1; i <= n-1; i++){ 
                if(array[n-1] < array[n-1-i]){
                    swap(n-1, n-1-i);
                } 
            }
            ordenaArray(array, n-1);
        }
    }
    

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 5; i ++){
            System.out.println("Digite o "+(i+1)+".o valor");
            array[i] = scanner.nextInt();
        }


        ordenaArray(array, array.length);
        for(int i = 0; i < 5; i ++){
            System.out.println((i+1)+".o valor: "+array[i]);
        }
        scanner.close();
    }
}
