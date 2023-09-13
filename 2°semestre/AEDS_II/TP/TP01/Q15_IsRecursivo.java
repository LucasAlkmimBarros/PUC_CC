class Q15_IsRecursivo{

	/*Funcao que verifica se o char e um int, um ponto ou uma virgula. Subtraimos 48 do "c" pois na tabela ASCII o char '0' fica na posicao 48 */

        public static boolean isReal(char c){
                boolean resp = false;

                if(((((int) c) - 48) >= 0 && (((int) c) - 48) < 10) || c == ',' || c == '.')
                {
                        resp = true;
                }
                return resp;
        }

        /* Funcao recursiva que verifica se a string e composta somente por inteiros, a variavel numVirgula serve para limitar o numero de ',' e '.' ,ja que um numero real so possui 1 */
        public static boolean strRealRecursiva(String str, int tam){
                boolean resp = true;
       
		if(tam == 1)
		{
			if(!(isReal(str.charAt(0)))) //Se nao for real
			{
				resp = false;
			}
		}
			else
			{
				if(!(isReal(str.charAt(tam-1)))) //Se nao for real
				{
					resp = false;
				}
               			else
				{
					resp = resp && strRealRecursiva(str, tam-1);
				}
             		}
                return resp;
        }


        /* Funcao que verifica se o char e um int, nessas funcao subtraimos 48 do c pois na tabela ASCII o char '0' fica na posicao 48 */
        public static boolean isInt(char c){
                boolean resp = false;
                if((((int) c) - 48) >= 0 && (((int) c) - 48) < 10)
                {
                        resp = true;
                }
                return resp;
        }

	/* Funcao recursiva que verifica se a string e composta somente por inteiros */
        public static boolean strIntRecursiva(String str, int tam){
                boolean resp = true;
	
		if(tam == 1)
		{
			if(!(isInt(str.charAt(0)))) //Se nao for inteiro
			{
				resp = false;
			}
		}
		else
		{
			if(!(isInt(str.charAt(tam-1)))) // Se nao for inteiro
			{
				resp = false;
			}
			else
			{
				resp = resp && strIntRecursiva(str, tam-1);
			}
		}

                return resp;
        }

        /* Funcao que verifica se o char e consoante */
        public static boolean isConsoante(char c){
                boolean resp = false;
                if((int) c > 96 && (int) c < 122 && !isVogal(c))
                {
                        resp = true;
                }
                return resp;
        }

        /* Funcao recursiva que verifica se a string e composta somente por consoantes */
        public static boolean strConsoantesRecursiva(String str, int tam){
                boolean resp = true;

		if(tam == 1)
		{
			if(!(isConsoante(str.charAt(0)))) //Se nao for consoante
			{
				resp = false;
			}
		}
		else
		{
			if(!(isConsoante(str.charAt(tam-1)))) //Se nao for consoante
			{
				resp = false;
			}
			else
			{
			resp = resp && strConsoantesRecursiva(str, tam-1);
			}
		}

                return resp;
	}

        /* Funcao que verifica se o char e vogal */
        public static boolean isVogal(char c){
                boolean resp = true;
                if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u')
                {
                        resp = false;
                }
                return resp;
        }

        /* Funcao recursiva que verifica se a string e composta somente por vogais */
        public static boolean strVogaisRecursiva(String str, int tam){
                boolean resp = true;
  
		if(tam == 1)
		{
			if(!(isVogal(str.charAt(0)))) //Se nao for vogal
			{
			       resp = false;
			}
		}
		else
		{
			if(!(isVogal(str.charAt(tam-1)))) //Se nao for vogal
			{
				resp = false;
			}
			else
			{
			resp = resp && strVogaisRecursiva(str, tam-1);
			}
		}
		return resp;
        }

	
	public static void main(String[] args){
                String str = "";
                boolean x1, x2, x3, x4;
                str = MyIO.readLine();
		int tam;
                do{
			tam = str.length();
                        String temp = "";
                        x1 = strVogaisRecursiva(str, tam);
                        x2 = strConsoantesRecursiva(str, tam);
                        x3 = strIntRecursiva(str, tam);
                        x4 = strRealRecursiva(str, tam);

                        if(x1) temp += "SIM ";
                        else temp += "NAO ";

                        if(x2) temp += "SIM ";
                        else temp += "NAO ";

                        if(x3) temp += "SIM ";
                        else temp += "NAO ";

                        if(x4) temp += "SIM ";
                        else temp += "NAO ";

                        MyIO.println(temp);
                        str = MyIO.readLine();

                }while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'));

        }

}






