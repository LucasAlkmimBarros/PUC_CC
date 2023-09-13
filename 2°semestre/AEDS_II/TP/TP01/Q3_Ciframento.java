public class Q3_Ciframento {
	public static String cifraString(String str){ //FUNCAO QUE ADICIONA +3 AO VALOR (INT) DO CARACTER DA STRING
		String strCifrada = "";
		int c;
		for (int i = 0; i < str.length(); i++){
			c = (int) str.charAt(i);
			c += 3;
			strCifrada += (char) c;
		}
		MyIO.println(strCifrada); //PRINTA STR CIFRADA
		return strCifrada;
	}
	public static void main(String[] args) {
		String str;
		str = MyIO.readLine(); //READ LINE
		do{
			cifraString(str);
			str = MyIO.readLine(); //READ LINE
		}while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')); //ENQUANTO NAO FOR FIM
	}
}
