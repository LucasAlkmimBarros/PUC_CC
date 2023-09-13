class Q10_PalindromoRecursivo{

	public static boolean ehPalindromo(String str, int inicio, int fim)
	{		
		boolean palindromo = true;
		if(inicio >= fim) //PONTO DE PARADA
		{
			return true;
		}
		else
		{
			if(str.charAt(inicio) != str.charAt(fim-1)) //CASO OS VALORES SEJAM DIFERENTES
								    //A VARIAVEL SERA FALSE, E, 
								    //CONSEQUENTEMENTE, A RESPOSTA
								    //SERA FALSE
			{
				palindromo = false;
			}
			else
			{
				palindromo = palindromo && ehPalindromo(str, inicio + 1, fim - 1);
			}
			return palindromo;
		}

	}



	public static void main(String[] args) {
       		MyIO.setCharset("UTF-8");
		String str;
		boolean resp;
            	str = MyIO.readLine(); //LE A LINHA
        	do{
            		resp = ehPalindromo(str, 0, str.length());
			if(resp) MyIO.println("SIM");
			else MyIO.println("NAO");
            		str = MyIO.readLine(); //LE A LINHA

       		}while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')); // ENQUANTO NAO FOR FIM
    }






}

