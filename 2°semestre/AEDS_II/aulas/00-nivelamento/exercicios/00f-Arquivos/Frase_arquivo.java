//QUESTAO 15

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class Frase_arquivo {
    public static void main(String args[]){
        System.out.println("Digite o nome do arquivo: ");
        Scanner teclado = new Scanner(System.in);
        String nome = teclado.nextLine();

        System.out.println("Digite a frase: ");
        String frase = teclado.nextLine();
        try {
            Formatter Arq = new Formatter(nome);

            Arq.format("%s%n", frase);


            Arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
        teclado.close();
    }
}
