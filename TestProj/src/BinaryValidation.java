import java.util.*;

public class BinaryValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ans;
        int base;
        char choice='y';

        do {
            System.out.print("Enter a positive integer: ");
            ans = getInt(input);
            if (ans < 0) {
                System.out.print("Must be a positive integer! Try again! REENTER: ");
                ans = getInt(input);
            }
            System.out.print("Enter a positive integer for base: ");
            base = getInt(input);
            if (base < 0) {
                System.out.print("Must be a positive integer! Try again! REENTER: ");
                base = getInt(input);
            }
            System.out.println("Sum of digits for " + ans + " is " + sumIterative(ans) + " (iterative solution)");
            System.out.println("Sum of digits for " + ans + " is " + sumRecursion(ans) + " (recursive solution)");
            binIterative(ans);
            System.out.print(ans + " in binary code is ");
            binRecursion(ans);
            System.out.println((" (recursive Solution)"));
            anyBase(ans, base);
            System.out.print(ans + " in binary code is ");
            anyBaseRecursion(ans, base);
            System.out.println((" (recursive Solution)"));
            System.out.print("Do you wish to continue (Y/N)? ");
            choice = input.next().charAt(0);
        }while (choice=='y' || choice == 'Y');
    }
    public static int getInt(Scanner input) {
        while (!input.hasNextInt()) {
            try {
                input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Must be a positive integer! Try again! REENTER: ");
                input.next();
            }
        }
        return input.nextInt();
    }
    //sum of digits iterative solution
    public static int sumIterative(int n){
        int sum = 0;
        while (n !=0){
            sum+=(n%10);
            n=(n/10);
        }
        return sum;
    }

    //recursive solution
    public static int sumRecursion(int n){
        if (n==0)
            return 0;
        else
            return(n %10 + sumRecursion(n/10));
    }
    //binary iterative solution
    public static void binIterative(int n){
        String binary ="";
        int m = n;
        if (m==0)
            binary= "0";
        else{
            while (m != 0){
                binary = m%2 + binary;
                m = m/2 ;
            }
            System.out.println(n +" in binary code is " + binary + " (iterative solution)");
        }
    }

    //binary recursive solution
    public static void binRecursion(int n){
        if (n>0) {
            binRecursion(n/2);
            System.out.print(n%2);
        }
    }

    //any base
    public static void anyBase(int n,int b){
        String num = "";
        int m=n;
        if (m==0)
            num= "0";
        else{
            while (m!= 0){
                num = m%b + num;
                m = m/b ;
            }
            System.out.println(n+ " in binary code with base "+ b + " is: "+ num + " (iterative solution)");
        }
    }
    //any Base recursive
    public static void anyBaseRecursion(int n,int b){
        int m = n;
        if (m>0) {
            anyBaseRecursion(m/b,b);
            System.out.print(+m%b);
        }
    }

}