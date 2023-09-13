//QUESTAO 18

import java.util.Scanner;

public class Tipo_triangulo {
    public static void main(String args[]){
        int lado1, lado2, lado3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor do lado: ");
        lado1 = scanner.nextInt();
        lado2 = scanner.nextInt();
        lado3 = scanner.nextInt();
        String tipoTriangulo;

        if(lado1 == lado2 && lado2 == lado3) tipoTriangulo = "equilátero";
        else if((lado1 != lado2 && lado1 == lado3 || lado2 == lado3) || (lado1 == lado2 && lado1 != lado3) || (lado1!= lado3 && lado3 == lado2)) tipoTriangulo = "isóceles";
        else tipoTriangulo = "Escaleno";

        System.out.println(tipoTriangulo);

        scanner.close();

    }
}
