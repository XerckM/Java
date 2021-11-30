import java.util.*;

public class ComplexNumber{
    private double real;
    private double image;

    public ComplexNumber(){
        real = 0;
        image = 0;
    }
    public ComplexNumber(int rl, int img){
        real = rl;
        image = img;
    }
    public void read(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a complex number (real imaginary): ");
        real = getDouble(in);
        image = getDouble(in);
    }
    private double getDouble(Scanner in){
        while(!in.hasNextDouble()){
            in.next();
            System.out.println("Not a double!!! Try again.");
        }
        return in.nextDouble();
    }
    public boolean equals(ComplexNumber value){
        return (real == value.real && image == value.image);
    }
    public String toString(){
        return ("(" + String.format("%.2f", real) + ", " + String.format("%.2f", image) + ")");
    }
    public void print() {
        System.out.print("(" + String.format("%.2f", real) + ", " + String.format("%.2f", image) + ")");
    }
    public double getReal(){
        return real;
    }
    public double getImaginary(){
        return image;
    }
    public void copy(ComplexNumber value){
        real = value.real;
        image = value.image;
    }
    public ComplexNumber getCopy(){
        ComplexNumber copy = new ComplexNumber();
        copy.real = real;
        copy.image = image;
        return copy;
    }
    public ComplexNumber add(ComplexNumber value){
        ComplexNumber ans = new ComplexNumber();
        ans.real = real + value.real;
        ans.image = image + value.image;
        return ans;
    }
    public ComplexNumber subtract(ComplexNumber value){
        ComplexNumber ans = new ComplexNumber();
        ans.real = real - value.real;
        ans.image = image - value.image;
        return ans;
    }
    public ComplexNumber multiply(ComplexNumber value){
        ComplexNumber ans = new ComplexNumber();
        ans.real = (real * value.real) - (image * value.image);
        ans.image = (image * value.image) - (real * value.image);
        return ans;
    }
    public ComplexNumber divide(ComplexNumber value){
        ComplexNumber ans = new ComplexNumber();
        ans.real = ((real * value.real) + (image * value.image)) / ((value.real * value.real) + (value.image * value.image));
        ans.image = ((image * value.image) - (image * value.image)) / ((value.real * value.real) + (value.image * value.image));
        return ans;
    }
    public double cAbs(){
        double ans = Math.sqrt(real * real + image * image);
        return ans;
    }
}