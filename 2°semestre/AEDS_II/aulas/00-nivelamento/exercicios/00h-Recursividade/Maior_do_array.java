//QUESTAO 23


import java.util.Scanner;

public class Maior_do_array {

    public static int calculaMaior(int[] array, int n){

        if(n==1){
            return array[0]; 
        }
        else{
            int maior = calculaMaior(array, n-1);
            if(maior > array[n - 1])
            return maior;
            else{
                return array[n-1];
            }
        }
    }


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        for(int i = 0; i < 5; i++){
            array[i] = scanner.nextInt();
        }

        int maior = calculaMaior(array, 5);
        System.out.println("O maior valor é: " + maior);

        scanner.close();
    }
}
