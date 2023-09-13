//QUESTAO 36

public class Retangulo {
    protected double base;
    protected double altura;


    public Retangulo(){

    }

    public Retangulo(double b, double h){
        base = b;
        altura = h;
    }

    public double getBase(){
        return base;
    }

    public void setBase(double b){
        base = b;
    }

    public void setAltura(double h){
        altura = h;
    }

    public double getAltura(){
        return altura;
    }

    public double getArea(){
        double area;
        area = base*altura;

        return area;
    }

    public double getPerimetro(){
        double perimetro;
        perimetro = 2*base + 2*altura;

        return perimetro;
    }

    public double getDiagonal(){
        double diagonal;
        diagonal = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));

        return diagonal;
    }
}
