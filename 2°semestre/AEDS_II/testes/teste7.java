import java.io.*;
import java.util.*;

class teste7{

	public static void strToChar(String str, char[] c)
		{
		}


	public static void main(String[] args){
		int primeiro, ultimo;
		String str = "";
		Scanner sc = new Scanner(System.in);
		primeiro = sc.nextInt();
		ultimo = sc.nextInt();
		
		for(int i = primeiro; i <= ultimo; i++) //Preenchendo a parte normal;
		{
			str += i;
		}
		
		for(int i = ultimo; i >= primeiro; i--)
		{
			String stri = "", striInversa = "";
			stri += i;
			char[] c = stri.toCharArray();
		//	strToChar(stri, c);
			int n = stri.length();
			if(n > 1){
				for (int j = n-1; j >= 0; j--){
					striInversa += c[j];
				}
			}
			else{
				striInversa += c[0];
			}
			str += striInversa;
		}			
			System.out.println(str);

	}


}
