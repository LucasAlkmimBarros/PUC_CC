class Q6_Is{

	/*Funcao que verifica se o char e um int, um ponto ou uma virgula. Subtraimos 48 do "c" pois na tabela ASCII o char '0' fica na posicao 48 */

	public static boolean isReal(char c){
		boolean resp = false;

                if(((((int) c) - 48) >= 0 && (((int) c) - 48) < 10) || c == ',' || c == '.')
                {
                        resp = true;
                }
                return resp;
        }

	/* Funcao que verifica se a string e composta somente por inteiros, a variavel numVirgula serve para limitar o numero de ',' e '.' ,ja que um numero real so possui 1 */
	public static boolean strReal(String str){
		boolean resp = true;
		int numVirgula = 0;

                for(int i = 0; i < str.length(); i++){
               		if (str.charAt(i) == ',' || str.charAt(i) == '.')
               		{
        	                numVirgula++;
	                }

                        if(!(isReal(str.charAt(i))) || numVirgula > 1)
                        {
                                resp = false;
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

	/* Funcao que verifica se a string e composta somente por inteiros */
	public static boolean strInt(String str){
		boolean resp = true;
		for(int i = 0; i < str.length(); i++){
			if(!(isInt(str.charAt(i))))
			{
				resp = false;
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

	/* Funcao que verifica se a string e composta somente por consoantes */
	public static boolean strConsoantes(String str){
		boolean resp = true;
		for(int i = 0; i < str.length(); i++){
			if(!(isConsoante(str.charAt(i))))
			{
				resp = false;
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

	/* Funcao que verifica se a string e composta somente por vogais */
	public static boolean strVogais(String str){
		boolean resp = true;
		for(int i = 0; i < str.length(); i++){
			if(!(isVogal(str.charAt(i))))
			{
				resp = false;
			}
		}
		return resp;
	}


	public static void main(String[] args){
		String str = "";
		boolean x1, x2, x3, x4;
		str = MyIO.readLine();
		do{
			String temp = "";
			x1 = strVogais(str);
			x2 = strConsoantes(str);
			x3 = strInt(str);
			x4 = strReal(str);
			
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
