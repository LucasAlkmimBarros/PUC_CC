//QUESTAO 14

public class Copia_arquivo {
    public static void main(String args[]) {
        Arq.openRead("C://Users//user//OneDrive///u00C1rea de Trabalho//PUC//2/u00B0 semestre//AEDS II//aulas//00-nivelamento//exercicios/exemplo.txt");

        if (Arq.hasNext()) {  // Verifica se há conteúdo para ler
            String str = Arq.readAll();  // Lê todo o conteúdo do arquivo
            Arq.close();

            Arq.openWrite("C://Users//user//OneDrive///u00C1rea de Trabalho//PUC//2/u00B0 semestre//AEDS II//aulas//00-nivelamento//exercicios/exemplo2.txt");
            Arq.print(str);
            Arq.close();
        } else {
            System.out.println("O arquivo está vazio.");
        }
    }
}

