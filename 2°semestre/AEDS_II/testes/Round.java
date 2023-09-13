class Round{

	public static void main(String[] args){
		double num, cut;
		num = MyIO.readDouble();
		cut = MyIO.readDouble();

		if((num - (int)num) > cut){
			num = (int)num + 1;
		}
		else{
			num = (int) num;
		}
		
		int resp = (int) num;
		MyIO.println(resp);
	}
}
