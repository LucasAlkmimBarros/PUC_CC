class taylor{
	public static void main(String[] args){
		String str="taylor";
		String cript="";
		int c;
		int crip;
		for(int i=0; i<6; i++){
			c = (int) str.charAt(i);
			crip = c+1;
			cript += (char) crip;	
		}
		MyIO.println("string normal: "+str);
		MyIO.println("string criptografada: "+cript);

	}


}
