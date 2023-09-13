import java.io.*;
import java.net.*;


class Q7_PaginaHTML{

   public static String getHtml(String endereco){
      	URL url;
      	InputStream is = null;
      	BufferedReader br;
      	String resp = "", line;

      	try {
        	url = new URL(endereco);
         	is = url.openStream();  // throws an IOException
         	br = new BufferedReader(new InputStreamReader(is));

         	while ((line = br.readLine()) != null) {
            	resp += line + "\n";
         	}
      	} catch (MalformedURLException mue) {
         	mue.printStackTrace();
      	} catch (IOException ioe) {
         	ioe.printStackTrace();
      	} 

      	try {
         	is.close();
      	} catch (IOException ioe) {
         // nothing to see here

      	}

      	return resp;
   	}

	/*Funcao que le <table>*/
	static public int leituraTable(String html)
	{
		int contador = 0; 
		int tam = html.length();
		for(int i = 0; i < tam; i++)
		{
			if (html.charAt(i) == '<' && html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a' && html.charAt(i + 3) == 'b' && html.charAt(i + 4) == 'l' && 
			html.charAt(i + 5) == 'e' && html.charAt(i + 6) == '>') contador++;
		}
		return contador;
	}

	/*Funcao que le <br>*/
	static public int leituraBr(String html)
	{
		int contador = 0;
		int tam = html.length();
		for(int i = 0; i < tam; i++)
		{
			if(html.charAt(i) == '<' && html.charAt(i+1) == 'b' && html.charAt(i+2) == 'r' && html.charAt(i+3) == '>') contador++;
		}
		return contador;
	}
	
	/*Funcao que le consoante*/
	static public int leituraConsoante(String html)
	{
		int contador = 0;
		int tam = html.length();
		for(int i = 0; i < tam; i++)
		{
			if(!((int)html.charAt(i)<97 || (int)html.charAt(i)>122 || html.charAt(i)=='i' || html.charAt(i)=='o' || html.charAt(i)=='u' || html.charAt(i)=='a' || html.charAt(i)=='e')){ //Verifica se nao e vogal
            contador++;
         }
		}
		return contador;
	}

	/*Funcao que le chars*/
	static public int leituraChar(String html, char c)
	{
		int contador = 0;
		int tam = html.length();
		for(int i = 0; i < tam; i++)
		{
			if(html.charAt(i) == c) contador++;
		}
		return contador;
	}

	public static void main (String[] args){

		String nome; //Nome da pagina
		int tam;
		String endereco; //URL da pagina
		String html = "";
		
		nome = MyIO.readLine();
		for(int i = 0; i < 10; i++){
			tam = nome.length();
			if(tam == 3 && nome.charAt(0)=='F' && nome.charAt(1)=='I' && nome.charAt(2)=='M')//Define o fim do codigo
				break;
			endereco = MyIO.readLine();
                	html = getHtml(endereco);

			int x1 = leituraChar(html,'a');
                        int x2 = leituraChar(html,'e'); 
                        int x3 = leituraChar(html,'i');
                        int x4 = leituraChar(html,'o');
                        int x5 = leituraChar(html,'u');
                        int x6 = leituraChar(html,'\u00e1'); //á 
                        int x7 = leituraChar(html,'\u00e9'); //é 
                        int x8 = leituraChar(html,'\u00ed'); //í  
                        int x9 = leituraChar(html,'\u00f3'); //ó 
                        int x10 = leituraChar(html,'\u00fa'); //ú 
                        int x11 = leituraChar(html,'\u00e0'); //à 
                        int x12 = leituraChar(html,'\u00e8'); //è 
                        int x13 = leituraChar(html,'\u00ec'); //ì 
                        int x14 = leituraChar(html,'\u00f2'); //ò 
                        int x15 = leituraChar(html,'\u00f9'); //ù 
                        int x16 = leituraChar(html,'\u00e3'); //ã 
                        int x17 = leituraChar(html,'\u00f5'); //õ 
                        int x18 = leituraChar(html,'\u00e2'); //â 
                        int x19 = leituraChar(html,'\u00ea'); //ê 
                        int x20 = leituraChar(html,'\u00ee'); //î 
                        int x21 = leituraChar(html,'\u00f4'); //ô 
                        int x22 = leituraChar(html,'\u00fb'); //û 
                        int x23 = leituraConsoante(html); //CONSOANTE
                        int x24 = leituraBr(html); //<br>
                        int x25 = leituraTable(html); // <table>

						if(x24 != 0){ //Tira <br> da contagem de consoantes
							for(int k = 0; k < x24; k++)
							{
									x23 = x23 - 2;
							}
						}

						if(x25 != 0){ //Tira <table> da contagem de consoantes, a, e
							for(int k = 0; k < x25; k++)
							{
									x1 = x1 - 1;
									x2 = x2 - 1;
									x23 = x23 - 3;
							}
						}
                
		MyIO.println("a(" + x1 + ") e(" + x2 + ") i(" + x3 + ") o(" + x4 + ") u(" + x5 + ") á(" + x6 + ") é(" + x7 + ") í(" + x8 + ") ó(" + x9 + ") ú(" + x10 + ") " +
      		"à(" + x11 + ") è(" + x12 + ") ì(" + x13 + ") ò(" + x14 + ") ù(" + x15 + ") ã(" + x16 + ") õ(" + x17 + ") â(" + x18 + ") ê(" + x19 + ") î(" + x20 + ") ô(" + x21 + ") û(" + x22 + ") " + "consoante(" + x23 + ") " + "<br>("+ x24 + ") <table>(" + x25 + ") " + nome);
			
		nome = MyIO.readLine();
		}
	}
}



