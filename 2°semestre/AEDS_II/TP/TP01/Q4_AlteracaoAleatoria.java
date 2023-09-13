import java.util.Random;

public class Q4_AlteracaoAleatoria{

	public static void main(String[] args){
		String str;
		str = MyIO.readLine();
                Random gerador = new Random(); //CRIA UM GERADOR RANDOMIZADO DE NUMEROS COM SEED 4
                gerador.setSeed(4);


		do{
                String newStr = "";
                char oldChar = (char)('a' + (Math.abs(gerador.nextInt()) %26)); //NA MEDIDA EM QUE O LOOP ACONTECE, O VALOR DAS VARIAVEIS "oldChar" E "newChar" MUDAM
                char newChar = (char)('a' + (Math.abs(gerador.nextInt()) %26));
                for(int i = 0; i < str.length(); i++){ //LACO QUE ALTERA O VALOR, CASO ELE SEJA A CHAVE (oldChar)
						       
                        if(str.charAt(i) == oldChar){ //SE FOR CHAR SORTEADO
                                newStr += newChar;
                        }
                        else{
                                newStr += str.charAt(i);
                        }
                }
                MyIO.println(newStr);
		str = MyIO.readLine();

		}while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'));	
	}
}	
