class Q14_AlgebraRec{

	public static String removerEspacos(String str) {
		return removerEspacosRecursivo(str, 0, "");
	}

	public static String removerEspacosRecursivo(String str, int index, String textoSemEspacos) { //FUNCAO RECURSIVA PARA REMOVER ESPACOS
    		if (index >= str.length()) {
        		return textoSemEspacos;
    		}

    		char currentChar = str.charAt(index);

    		if (currentChar != ' ') {
        		textoSemEspacos += currentChar;
    		}

    		return removerEspacosRecursivo(str, index + 1, textoSemEspacos);
	}


	public static boolean intToBool(int num) //CONVERTE INT EM BOOLENA
	{
		boolean resp = true;
		if(num == 0) resp = false;
		return resp;
	}

	public static void strToChar(String str, char[] c) //CONVERTE STRING EM CHAR[] 
	{
		for(int i = 0; i < str.length(); i++)
		{
			c[i] = str.charAt(i);
		}
	}


	public static String atualizaStr(char[] c, int tam) //CONVERTE CHAR[] EM STRING
	{
		return atualizaStrRec(c, tam, 0);
	}

	public static String atualizaStrRec(char[] c, int tam, int i) //FUNCAO RECURSIVA QUE CONVERTE CHAR[] EM STRING
	{
		if(i >= tam) return "";
		else
		{
			return c[i] + atualizaStrRec(c, tam, i+1);
		}
	}

	public static String getEquacaoRec(char[] c, int tam, int contador) {
    		if (contador + 1 >= tam) {
        		return "";
    		} else {
        		return c[contador + 1] + getEquacaoRec(c, tam, contador + 1);
    		}
		}


	public static String solucionaEquacao(String equacao) 
	{
		equacao = removerEspacos(equacao);
//		MyIO.println(equacao);
		equacao = substituiEquacaoRec(equacao); //CHAMA A FUNCAO RECURSIVA
		return equacao;
	}

	public static String substituiEquacaoRec(String equacao) //FUNCAO RECURSIVA PARA RESOLVER A EQUACAO
	{
		if(equacao.length() <= 1)
		{
			return equacao;
		}
		else
		{
		 equacao = equacao.replace("not(1)","0");
		 equacao = equacao.replace("not(0)","1");
		
		 equacao = equacao.replace("and(1)","1");
		 equacao = equacao.replace("and(0)","0");

		 equacao = equacao.replace("or(1)","1");
		 equacao = equacao.replace("or(0)","0");

		 equacao = equacao.replace("and(0,0","and(0");
		 equacao = equacao.replace("and(0,1","and(0");
		 equacao = equacao.replace("and(1,0","and(0");
		 equacao = equacao.replace("and(1,1","and(1");

		 equacao = equacao.replace("or(0,0","or(0");
		 equacao = equacao.replace("or(0,1","or(1");
		 equacao = equacao.replace("or(1,0","or(1");
		 equacao = equacao.replace("or(1,1","or(1");

		}
		
		return substituiEquacaoRec(equacao);
	}

	
	public static void main(String[] args)
	{
		String str;
		int n;
		int posDoArray = 0;
		int[] valorBool = new int[3];
		char[] charString = new char[300];
		int contador;

		str = MyIO.readLine();
		do
		{
			strToChar(str, charString);
			contador = 0;
			do
			{
				n = (((int) charString[contador]) - 48);       //LACO PARA OBTER O VALOR DE N (NUMERO DE ENTRADAS)
				contador++;
				posDoArray++;
			}while(!(n == 2 || n == 3));
			
			for(int i = 0; i < n; i++)
			{
				do{
					valorBool[i] = (int)charString[contador] - 48;      
					contador++;	
				}while(!(valorBool[i] == 0 || valorBool[i] == 1));   //ATRIBUINDO UM VALOR BOOLEANO (0 ou 1) VALIDO PARA A VARIAVEL
			}

			for(int i = 0; i < str.length(); i++) //SUBSTITUINDO A, B, C PELOS SEUS VALORES
			{
				char c;
				if(charString[i] == 'A')
				{
					c = (char) ('0' + valorBool[0]);
					charString[i] = c;
				}
				else if(charString[i] == 'B')
				{
					c = (char) ('0' + valorBool[1]); 
					charString[i] = c;
				}
				else if(charString[i] == 'C')
				{
					c = (char) ('0' + valorBool[2]);
					charString[i] = c;
				}	
			}

			str = atualizaStr(charString, str.length()); //ATUALIZA STRING
			
			String equacao = getEquacaoRec(charString, str.length(), contador); //PEGA SOMENTE A EQUACAO

			String resultado = solucionaEquacao(equacao);
			MyIO.println(resultado);

			str = MyIO.readLine();
		}while(!(str.length() == 1 && str.charAt(0) == '0')); 

	
	}
}
