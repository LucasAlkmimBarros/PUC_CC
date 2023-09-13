//QUESTAO 30


public class Torre_Hanoi {
    public static void torre_hanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }
        
        torre_hanoi(n - 1, origem, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
        torre_hanoi(n - 1, auxiliar, destino, origem);
    }

    public static void main(String[] args) {
        int numDiscos = 3; 
        torre_hanoi(numDiscos, 'A', 'C', 'B'); 
    }
}
