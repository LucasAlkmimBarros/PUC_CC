class Q5_AlgebraBooleana{

        public static String removerEspacos(String str) { // REMOVE OS ESPACOS
        String textoSemEspacos = "";
        for(int i = 0; i < str.length(); i++)
        {
                if(str.charAt(i) != ' ')
                {
                        textoSemEspacos += str.charAt(i);
                }
        }
        return textoSemEspacos;
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
		String str = "";
		for(int i = 0; i < tam; i++)
		{
			str += c[i];
		}
		return str;
	}

	public static String getEquacao(char[] c, int tam, int contador) //RETORNA SOMENTE A EQUACAO
	{
		String str = "";
		for(int i = contador+1; i < tam; i++)
		{
			str+= c[i];
		}
		return str;
	}

	public static String solucionaEquacao(String equacao)
	{
		equacao = removerEspacos(equacao);
		equacao = substituiEquacao(equacao);
		return equacao;
	}


	public static String substituiEquacao(String equacao) //FUNCAO PARA RESOLVER A EQUACAO
	{
		do{
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

		
		}while(equacao.length() > 2);
		return equacao;
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
			
			String equacao = getEquacao(charString, str.length(), contador); //PEGA SOMENTE A EQUACAO

			String resultado = solucionaEquacao(equacao);
			MyIO.println(resultado);

			str = MyIO.readLine();
		}while(!(str.length() == 1 && str.charAt(0) == '0')); 

	
	}
}
