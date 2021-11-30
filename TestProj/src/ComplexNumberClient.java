import java.util.*;

public class ComplexNumberClient{
    private static int ctr = 0;
    public static void main(String[]args){
        Scanner in= new Scanner(System.in);
        ComplexNumber cn1 = new ComplexNumber();
        ComplexNumber cn2 = new ComplexNumber();
        int choice;
        do{
            choice = menu(in);
            switch(choice){
                case 1: 
                    cn1.read();
                    cn2.read();
                    System.out.println("First complex number is: " + cn1);
                    System.out.println("Second complex number is: " + cn2);
                    System.out.println("Result: " + cn1.toString() + " + " + cn2.toString() + " = " + cn1.add(cn2));
                    System.out.println("Command number " + ctr + " completed!\n");
                    System.out.println();
                    break;
                case 2:{
                    cn1.read();
                    cn2.read();
                    System.out.println("First complex number is: " + cn1);
                    System.out.println("Second complex number is: " + cn2);
                    System.out.println("Result: " + cn1.toString() + " - " + cn2.toString() + " = " + cn1.subtract(cn2));
                    System.out.println("Command number " + ctr + " completed!\n");
                    System.out.println();
                    break;
                }
                case 3:{
                    cn1.read();
                    cn2.read();
                    System.out.println("First complex number is: " + cn1);
                    System.out.println("Second complex number is: " + cn2);
                    System.out.println("Result: "  + cn1.toString() + " * " + cn2.toString() + " = " +  cn1.multiply(cn2));
                    System.out.println("Command number " + ctr + " completed!\n");
                    System.out.println();
                    break;
                }
                case 4:{
                    cn1.read();
                    cn2.read();
                    System.out.println("First complex number is: " + cn1);
                    System.out.println("Second complex number is: " + cn2);
                    System.out.println("Result: "  + cn1.toString() + " / " + cn2.toString() + " = " +  cn1.divide(cn2));
                    System.out.println("Command number " + ctr + " completed!\n");
                    System.out.println();
                    break;
                }
                case 5:{
                    cn1.read();
                    System.out.println("The complex number is: " + cn1);
                    System.out.println("Result: " + "|" + cn1.toString() + "|" + " = " + String.format("%.2f", cn1.cAbs()));
                    System.out.println("Command number " + ctr + " completed!\n");
                    System.out.println();
                    break;
                }
                case 6:{
                    cn1.read();
                    cn2.read();
                    System.out.println("First complex number is: " + cn1);
                    System.out.println("Second complex number is: " + cn2);
                    if(cn1.equals(cn2)){
                      System.out.println("The complex numbers are equal.");
                    }
                    else{
                      System.out.println("The complex numbers are NOT equal.");
                    }
                    System.out.println("Command number " + ctr + " completed!\n");
                    System.out.println();
                    break;
                }
                default:{
                    System.out.println("Testing completed.");
                }
            }
        }while(choice != 0);
    }
    public static int menu(Scanner input){
        int option;
        do{
            System.out.println("Your options for Complex arithmetics are: ");
            System.out.println("---------------------------------------- ");
            System.out.println(" 1) Add 2 complex numbers");
            System.out.println(" 2) Subtract 2 complex numbers ");
            System.out.println(" 3) Multiply 2 complex numbers ");
            System.out.println(" 4) Divide 2 complex numbers ");
            System.out.println(" 5) Absolute value of a complex number ");
            System.out.println(" 6) Compare 2 complex numbers ");
            System.out.println(" 0) EXIT");
            System.out.print("Please enter your option: ");
            option = getInt(input);
        }while(option < 0 || option > 6);
        ctr += 1;
        return option;
    }
    public static int getInt(Scanner in){
        while(!in.hasNextInt()){
            try{
                in.nextInt();
            } catch (InputMismatchException e){
                System.out.print("Not an integer! Try again! Please enter your option: ");
                in.next();
            }
        }
        return in.nextInt();
    } 
}