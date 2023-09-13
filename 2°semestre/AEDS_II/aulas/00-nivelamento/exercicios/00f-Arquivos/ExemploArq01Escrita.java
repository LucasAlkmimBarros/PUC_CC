//QUESTAO 12
import java.io.FileNotFoundException;
import java.util.Formatter;

public class ExemploArq01Escrita {
    public static void main(String args[]){
        try {
            Formatter Arq = new Formatter("exemplo.txt");

            Arq.format("%d%n", 1);
            Arq.format("%.1f%n", 5.3);
            Arq.format("%c%n", 'X');
            Arq.format("%b%n", true);
            Arq.format("%s%n", "Algoritmos");

            Arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }


    }
}
