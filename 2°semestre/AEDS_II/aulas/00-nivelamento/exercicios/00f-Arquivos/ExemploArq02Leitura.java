//QUESTAO 13
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class ExemploArq02Leitura {
    public static void main(String args[]) {
        try {
            Formatter escritor = new Formatter("exemplo.txt");

            escritor.format("%d%n", 1);
            escritor.format("%.1f%n", 5.3);
            escritor.format("%c%n", 'X');
            escritor.format("%b%n", true);
            escritor.format("%s%n", "Algoritmos");

            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }

        try {
            Scanner leitor = new Scanner(new java.io.File("exemplo.txt"));

            int i = leitor.nextInt();
            double d = leitor.nextDouble();
            char c = leitor.next().charAt(0);
            boolean b = leitor.nextBoolean();
            String s = leitor.next();

            System.out.println(i);
            System.out.println(d);
            System.out.println(c);
            System.out.println(b);
            System.out.println(s);

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}
