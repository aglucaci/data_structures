//https://www.mathsisfun.com/numbers/complex-numbers.html

public class ComplexNumber {

    //Variables for the class
    private double a;
    private double b;

    //Constructor for the class
    public ComplexNumber (double a, double b) {
        this.a = a;
        this.b = b;
    }

    //Methods for the class
    public ComplexNumber add (ComplexNumber other) {
        double newReal = this.a + other.a;
        double newComplex = this.b + other.b;
        PrintNumber(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber subtract (ComplexNumber other) {
        double newReal = this.a - other.a;
        double newComplex = this.b - other.b;
        PrintNumber(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber multiply (ComplexNumber other) {
        double newReal = (this.a * other.a) - (this.b * other.b);
        double newComplex = (this.a * other.b) + (this.b * other.a);
        PrintNumber(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber divide (ComplexNumber other) {
        //https://en.wikipedia.org/wiki/Complex_number#Multiplication
        //https://algs4.cs.princeton.edu/99scientific/Complex.java.html
        //https://www.math.ksu.edu/~bennett/jomacg/c.html
        double conjugate = 1 / (Math.pow(other.a, 2) + Math.pow(other.b, 2));
        double newReal = conjugate * ((this.a * other.a) + (this.b * other.b));
        double newComplex = conjugate * ((this.b * other.a) - (this.a * other.b));;

        PrintNumber(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);

    }

    public void PrintNumber(ComplexNumber num) {
        //String char = System.out.toString(num);
        System.out.println("A: " + num.a + " and B: " + num.b);

    }

    //2.3
    //4.5

    //3.4
    //5.5


}
