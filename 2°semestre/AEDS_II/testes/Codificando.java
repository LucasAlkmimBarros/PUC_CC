import java.util.*;

class Codificando{

	public static void main(String[] args){
		String str;
		str = MyIO.readLine();
		String rep = "";
		String resp = "";

		
		for(int i = 0; i < str.length(); i++){
			resp = "";
			rep = "";
			int c = str.charAt(i);
			int qt = (int) c - 48;
			if(qt >= 1 && qt < 9){
				int j = 1; //pula o primeiro [
				//int qtChave = 1; 
				/*while(qtChave > 0){
					MyIO.println("entrou");
					if(str.charAt(i+j) == '[') qtChave++;
					else if(str.charAt(i+j) == ']') qtChave--;
					else{
						rep += str.charAt(j); 
					}
				}*/
				
				while(!(str.charAt(i+j) == ']')){
					rep += str.charAt(i+j+1);
					j++;
				}
				
				for(int k = 0; k < qt; k++)
				{
					resp += rep;
				}
				MyIO.println(resp);
			}
		}

	}


	

}
