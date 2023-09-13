//QUESTAO 38

public class Ponto {
    private double x;
    private double y;
    private int id;
    private static int nextID = 0;

    public Ponto(){
        x = 0;
        y = 0;
        id = nextID;
        nextID++;
    }

    public Ponto(double num1, double num2){
        x = num1;
        y = num2;
        id = nextID;
        nextID++;
    }

    public double getX(){
        return x;
    }

    public void setX(double num){
        x = num;
    }

    public double getY(){
        return y;
    }

    public void setY(double num){
        y = num;
    }

    public int getId(){
        return id;
    }
}
