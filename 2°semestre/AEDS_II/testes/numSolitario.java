import java.util.*;

class numSolitario{
	public static String removeEspaco(String str){
		String resp = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(!(str.charAt(i) == ' ')) resp += str.charAt(i);
		}
		return resp;
	}



	public static void main(String[] args){
		int n;
		String str;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine(); //limpa o buffer
		str = sc.nextLine();

		str = removeEspaco(str);

		int tmp, quant;
		for(int i = 0; i < str.length(); i++){
			quant = 0;
			tmp = str.charAt(i);
			for(int j = 0; j < str.length(); j++){
				if(str.charAt(j) == tmp) quant ++;
			}
			if(quant % 2 != 0) System.out.println(str.charAt(i));


		}
			
	
	//	System.out.println(str);
	}
}

