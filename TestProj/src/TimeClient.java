import java.util.*;

public class TimeClient {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        Time t1 = new Time(8, 15, 30);
        Time t2 = new Time();
        int hrs;
        int mins;
        int secs;

        System.out.print("Initial time t1 (alternate constructor invoked) - military format: "); 
        t1.printMilitary(); 
        System.out.println();

        System.out.print("Initial time t1 (alternate constructor invoked) - standard format: "); 
        t1.printStandard(); 
        System.out.println();

        System.out.print("Initial time t2 (default constructor invoked) - military format: "); 
        t2.printMilitary(); 
        System.out.println(); 
        System.out.print("Initial time t2 (default constructor invoked) - standard format: "); 
        t2.printStandard(); 
        System.out.println();

        t2.set(9, 45, 35); 
        System.out.print("t2 after call to setTime - military format: "); 
        t2.printMilitary(); 
        System.out.println(); 
        System.out.print("t2 after call to setTime - standard format: "); 
        t2.printStandard(); 
        System.out.println();

        if(t1.equals(t2)){
            System.out.println("After call to equals: times are equal."); 
        }
        else {
            System.out.println("After call to equals: times are NOT equal.");
        }
        if(t1.notEquals(t2)) {
            System.out.println("After call to notEquals: times are NOT equal."); 
        }
        else {
            System.out.println("After call to notEquals: times are equal.");
        }
        if(t1.lessThan(t2)) {
            System.out.println("After call to lessThan: t1 is less than t2."); 
        }
        else {
            System.out.println("After call to lessThan: t1 is NOT less than t2.");
        }
        if(t1.greaterThan(t2)) {
            System.out.println("After call to greaterThan: t1 is greater than t2."); 
        }
        else {
            System.out.println("After call to greaterThan: t1 is NOT greater than t2.");
        } 
        if(t1.greaterOrEquals(t2)) {
            System.out.println("After call to greaterOrEquals: t1 is greater than t2 or the times are equal."); 
        }
        else {
            System.out.println("After call to greaterOrEquals: t1 is NOT greater than or equal to t2.");
        }
        if(t1.lessOrEquals(t2)) {
            System.out.println("After call to lessOrEquals: t1 and t2 are equal or t1 is less than t2."); 
        }
        else {
            System.out.println("After call to lessOrEquals: t1 is not less than or equal to t2.");
        }
        
        boolean isValid = false;
        while (!isValid){
            System.out.print("Enter hours, minutes, and seconds: ");
            hrs = getInt(in);
            mins = getInt(in); 
            secs = getInt(in);
            if (hrs < 0 || mins < 0 || secs < 0){
                System.out.print("Not valid integers! Try again. ");
            }
            else{
                t1.set(hrs, mins, secs); 
                isValid = true;
            }
        }

        System.out.println();
        System.out.print("New time t1 after call to setTime - standard format: "); 
        t1.printStandard(); 
        t1.advanceSecs(); 
        System.out.println();
        System.out.print("New time t1 after call to increment - standard format: ");
        t1.printStandard();
        t1.advanceHrs();
        System.out.println();
        System.out.print("New time t1 after call to advanceHrs - standard format: ");
        t1.printStandard();
        t1.advanceMins();
        System.out.println();
        System.out.print("New time t1 after call to advanceMins - standard format: ");
        t1.printStandard();
        t1.advanceSecs();
        System.out.println();
        System.out.print("New time t1 after call to advanceSecs - standard format: ");
        t1.printStandard(); 
        System.out.println();

        t2.copy(t1); 
        System.out.print("New t2 after call to copy - standard format: "); 
        t2.printStandard(); 
        System.out.println(); 
        System.out.println("Test toString for t2: " + t2); 
    }
    public static int getInt(Scanner in){
        while(!in.hasNextInt()) {
            try{
                in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Not an integer! Try again. Enter hours, minutes, and seconds: ");
                in.next();
            }
        }
        return in.nextInt();
    }
}