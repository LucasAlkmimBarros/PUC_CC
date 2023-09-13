class Q12_CiframentoRecursivo{

	public static String cifraString(String str, int tam){ //FUNCAO QUE ADICIONA +3 AO VALOR (INT) DO CARACTER DA STRING
		String strCifrada = "";
		int c;

		if(tam == 1) //caso base(1)
		{
			c = (int) str.charAt(0);
			c += 3;
			strCifrada += (char)c;
		}
		else 
		{
			c = (int) str.charAt(tam-1);
			c += 3;
			strCifrada = cifraString(str, tam-1) + (char) c; //o valor sempre e adiocionado ao final da stirng, por isso comecamos cifrando o maior
		}

	return strCifrada;	

	}

        public static void main(String[] args) {
                String str;
                str = MyIO.readLine(); //READ LINE
                do{
                        str = cifraString(str, str.length());
			MyIO.println(str);
                        str = MyIO.readLine(); //READ LINE
                }while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')); //ENQUANTO NAO FOR FIM
        }

}
