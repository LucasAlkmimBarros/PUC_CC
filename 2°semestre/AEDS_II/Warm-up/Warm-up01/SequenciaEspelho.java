class SequenciaEspelho{

	public static void imprimeEspelho(int min, int max)
	{
		String str = "";
		String strNormal = "";
		String strInvertida = "";

		/* Nesse laco atribuimos a parte "normal da string", que nao esta invertida */
		for(int i = min; i <= max; i++)
		{
			strNormal += i;
		}

		/* Aqui, vamos inverter a ordem da string, e, se necessario, a ordem do numero */
		for(int i = max; i >= min; i--) //Invertendo a ordem da string
		{
			String num = "";
			String numInverso = "";	
			num += i;
			
			if(i > 9) //Invertendo a ordem do numero
			{
				for(int j = num.length(); j > 0; j--)
				{
					numInverso += num.charAt(j-1);
				}
			}
			else //Caso o numero so tenha uma casa
			{
				numInverso = num;
			}
			strInvertida += numInverso;
		}
		
		str+= strNormal;
		str+= strInvertida;

		MyIO.println(str);	
		
	}

	public static void main(String[] args)
	{
		int max, min;

		for(int i = 0; i<3; i++)
		{
			min = MyIO.readInt();
			max = MyIO.readInt();

			imprimeEspelho(min, max);
		}
	}



}

