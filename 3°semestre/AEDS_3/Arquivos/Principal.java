import java.io.*;

class Principal {

  public static void main(String args[]) {

    File f = new File("dados/livros.db");
    File f2 = new File("dados/autores.db");
    f.delete();
    f2.delete();

    Arquivo<Livro> arqLivros;
    Livro l1 = new Livro(-1, "9788563560278", "Odisseia", 15.99F);
    Livro l2 = new Livro(-1, "9788584290482", "Ensino Híbrido", 39.90F);
    Livro l3 = new Livro();
    int id1, id2;

    Arquivo<Autor> arqAutores;
    Autor a1 = new Autor(-1, "Homer", "Grécia");
    Autor a2 = new Autor(-1, "Clayton Christensen", "EUA");
    Autor a3 = new Autor(-1, "J.K Rolling", "EUA");

    try {
      /*
      arqLivros = new Arquivo<>("dados/livros.db", Livro.class.getConstructor());

      id1 = arqLivros.create(l1);
      System.out.println("Livro criado com o ID: " + id1);

      id2 = arqLivros.create(l2);
      System.out.println("Livro criado com o ID: " + id2);

      if (arqLivros.delete(id2))
        System.out.println("Livro de ID " + id2 + " exclu[ido!");
      else
        System.out.println("Livro de ID " + id2 + " não encontrado!");

      l1.setTitulo("A Odisséia");
      if (arqLivros.update(l1))
        System.out.println("Livro de ID " + l1.getID() + " alterado!");
      else
        System.out.println("Livro de ID " + l1.getID() + " não encontrado!");

      if ((l3 = arqLivros.read(id1)) != null)
        System.out.println(l3);
      else
        System.out.println("Livro de ID " + id1 + " não encontrado!");

      if ((l3 = arqLivros.read(id2)) != null)
        System.out.println(l3);
      else
        System.out.println("Livro de ID " + id2 + " não encontrado!");
    
      

      arqLivros.close();
      */

      
      arqAutores = new Arquivo<>("dados/autores.db", Autor.class.getConstructor());


      id1 = arqAutores.create(a1);
      System.out.println("Autor criado com o ID: " + id1);

      id2 = arqAutores.create(a2);
      System.out.println("Autor criado com o ID: " + id2);

      if ((a1 = arqAutores.read(id1)) != null)
      System.out.println(a1);
      else
      System.out.println("Autor de ID " + id1 + " não encontrado!");

      a1.setNome("Homero");

      if (arqAutores.update(a1))
        System.out.println("Autor de ID " + a1.getID() + " alterado!");
      else
        System.out.println("Autor de ID " + a1.getID() + " não encontrado!");

      if ((a1 = arqAutores.read(id1)) != null)
        System.out.println(a1);
      else
        System.out.println("Autor de ID " + id1 + " não encontrado!");

      a1.setNome("Lucas");

      if (arqAutores.update(a1))
        System.out.println("Autor de ID " + a1.getID() + " alterado!");
      else
        System.out.println("Autor de ID " + a1.getID() + " não encontrado!");

      //delete


      arqAutores.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}