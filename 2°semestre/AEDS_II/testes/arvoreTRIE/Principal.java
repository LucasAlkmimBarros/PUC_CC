class Principal{
	public static void main(String[] args){
		ArvoreTRIE a = new ArvoreTRIE();

		a.inserir("Lucas");
		a.inserir("Luis");
		a.inserir("Lucas");
		a.inserir("Marcela");
		a.inserir("Lucca");


		if(a.pesquisar("Lucas")){
			System.out.println("Lucas");
		}

		if(a.pesquisar("Lu")){
                        System.out.println("Lu");
          
		}
                if(a.pesquisar("Lucasaca")){
                        System.out.println("Lucasaca");
                }
                if(a.pesquisar("Lucca")){
                        System.out.println("Lucca");
                }

		a.mostrar();
		System.out.println("------------");
		a.mostrar2();

	}
}
