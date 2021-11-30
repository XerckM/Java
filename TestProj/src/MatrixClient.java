import java.util.Scanner;
public class MatrixClient
{
    public static final int MAX = 20; 
    public static final int LOW = 1; 
    public static final int UP = 10;
    
    public static void main(String[] args) 
    { 
        Scanner input = new Scanner(System.in); 
        int choice; //operation to be executed from menu 
        int numCommands = 0; //display counter 
        int size; //for subarray processing 
        int value; //multiply matrix by this constant 
        int tr; //return from trace() 
    
        System.out.print("Enter the size of the square matrix: ");
        size = getInt(input);
    
        while(size <= 0 || size > MAX)
        {
          System.out.println("INPUT ERROR!!! Invalid size. Size should be positive and <= " + MAX + ".");
          System.out.print("Enter the size of the square matrix: ");
          size = getInt(input);
        }
        
        Matrix first = new Matrix(size); 
        Matrix second = new Matrix(size); 
        Matrix result = new Matrix(size); 
    
        choice = menu(input);
        while(choice!=0)
        {
            numCommands++;
            switch(choice)
            {
                case 1: //Addition
                    first.init(LOW,UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    second.init(LOW,UP);
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The sum of the matrices is: ");
                    result = first.add(second);
                    result.print();
                    break;
                case 2: //Subtraction
                    first.init(LOW,UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    second.init(LOW,UP);
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The difference of the matrices is: ");
                    result=first.subtract(second);
                    result.print();
                    break;
                case 3: //Matrix multiplication
                    first.init(LOW,UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    second.init(LOW,UP);
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The product of matrices is: ");
                    result=first.multiply(second);
                    result.print();
                    break;
                case 4: //Multiplication by constant
                    first.init(LOW,UP);
                    System.out.println("The matrix is: ");
                    first.print();
                    System.out.println("Enter a value to multiply by: ");
                    value=getInt(input);
                    System.out.println("The product of the matrix with " + value + " is: ");
                    result=first.multConstant(value);
                    result.print();
                    break;
                case 5: //Transposition
                    first.init(LOW,UP);
                    System.out.println("The matrix is: ");
                    first.print();
                    System.out.println("The transpose of the matrix is: ");
                    result=first.transpose();
                    result.print();
                    break;
                case 6: //Trace
                    first.init(LOW,UP);
                    System.out.println("The matrix is: ");
                    first.print();
                    tr=first.trace();
                    System.out.println("The trace of the matrix is: " + tr);
                    break;
                case 7: //Copy
                    first.init(LOW,UP);
                    System.out.println("The first matrix is : ");
                    first.print();
                    result.copy(first);
                    System.out.println("The copy is: ");
                    result.print();
                    System.out.println("Testing for equality. Should be equal...");
                    if(first.equals(result))
                    {
                      System.out.println("The matrices are equal!!");
                    }
                    else
                    {
                      System.out.println("Uh oh, not equal! :/");
                    }
                    break;
                case 8: //Test for equality
                    first.init(LOW,UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    second.init(LOW,UP);
                    System.out.println("The second matrix is: ");
                    second.print();
                     if(first.equals(second))
                    {
                      System.out.println("The matrices are equal!!");
                    }
                    else
                    {
                      System.out.println("Matrices are not equal!!");
                    }
                    break;
                default:
                    System.out.println("Testing completed");
            } 
            System.out.println("Command number " + numCommands + " completed.");
            choice = menu(input);
        }
        System.out.println("Testing Completed");
        }
    public static int menu(Scanner input){
        int option;
        do{
            System.out.println("\nYour options are: ");
            System.out.println("----------------- ");
            System.out.println(" 1) Add 2 matrices");
            System.out.println(" 2) Subtract 2 matrices ");
            System.out.println(" 3) Multiply 2 matrices ");
            System.out.println(" 4) Multiply matrix by a constant ");
            System.out.println(" 5) Transpose matrix ");
            System.out.println(" 6) Matrix trace ");
            System.out.println(" 7) Make a copy of a matrix ");
            System.out.println(" 8) Test for equality ");
            System.out.println(" 0) EXIT");
            System.out.print("Please enter your option: ");
            option = getInt(input);
        }while(option < 0 || option > 8);
        return option;
    }
    
    public static int getInt(Scanner input){
        while(!input.hasNextInt())
        {
          input.next();
          System.out.print("ERROR!!! Not an integer. Try again. Please enter your option: ");
        }
        return input.nextInt();
    }
}