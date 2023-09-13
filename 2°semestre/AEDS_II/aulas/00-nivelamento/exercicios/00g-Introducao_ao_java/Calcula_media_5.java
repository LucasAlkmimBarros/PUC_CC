//QUESTAO 19

import java.util.Scanner;

public class Calcula_media_5 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int nota;
        int soma = 0;
        int i = 0;
        while(i < 5){
            nota = scanner.nextInt();
            soma += nota;
            i++;
        }


        float media = (float) soma/5;

        System.out.println(media);

        scanner.close();
}
}
