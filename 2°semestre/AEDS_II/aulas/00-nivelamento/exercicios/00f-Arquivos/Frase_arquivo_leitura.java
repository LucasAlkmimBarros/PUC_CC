//QUESTAO 16
import java.util.Scanner;



public class Frase_arquivo_leitura {
    public static void main(String args[]){
        System.out.println("Digite o nome do arquivo: ");
        Scanner teclado = new Scanner(System.in);
        String nome = teclado.nextLine();

            Arq.openRead(nome);

            if (Arq.hasNext()) {  // Verifica se há conteúdo para ler
                String str = Arq.readAll();  // Lê todo o conteúdo do arquivo
                Arq.close();

                Arq.openWrite("C://Users//user//OneDrive///u00C1rea de Trabalho//PUC//2/u00B0 semestre//AEDS II//aulas//00-nivelamento//exercicios/exemplo2.txt");
                Arq.print(str);
                Arq.close();
            } else {
                System.out.println("O arquivo está vazio.");
            }

        teclado.close();
    }
}
