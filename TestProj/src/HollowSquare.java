import java.util.*;

public class HollowSquare {
    private static Scanner in = new Scanner(System.in); // created class level scanner variable "in" to apply through the whole class instead of creating more scanner variables
    public static void main(String[] args){
        char ans;
        boolean isEnabled = true; // created boolean to loop through first user input
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to create a hollow box (Y/N)? ");
        ans = in.next().charAt(0);
        do{
            if ((ans == 'Y') || (ans == 'y')){ // the rest of the code executes when user inputs Y or y
                int range = getRange();
                printBox(range);
                System.out.println();
                System.out.print("Do you want to create a hollow box (Y/N)? ");
                ans = in.next().charAt(0);
            }
            else if ((ans == 'N') || (ans == 'n')){ // breaks the loop and exits the program when user input is N or n
                in.close();
                isEnabled = false;
            }
            else{
                System.out.println("Only answer with 'Y' or 'y' for Yes, and 'N' or 'n' for No."); // raises error message when user input is other than intended
            }
        } while (isEnabled);
    }
    public static int getRange(){
        /*

        This method will take user input and will check for validity.
        Try-catch is used to check user input and will raise an error if the-
        -character is not an integer

        */
        int range = 0;
        boolean isValid = false;
        System.out.print("How many chars/last row? ");
        do{ // do-while loop to catch error InputMismatchException for non-integer characters
            try{
                range = in.nextInt();
                if (isValidRange(range) == true){ // uses the isValidRange() method to validate if user input is within range and exits the loop and returns the range
                    isValid = true;
                    return range;
                }
                else{
                    System.out.print("ERROR! Valid range 5 - 21. How many chars/last row? "); // raises error message when input is not in the valid range
                }
            } catch (InputMismatchException e){ // when non-integer character is passed it raises this error
                System.out.print("Not an integer! Try again! How many chars/last row? ");
                in.next();
            }
        } while (!isValid);
        return range;
    }
    public static boolean isValidRange(int range){
        /*

        This method returns a boolean if the user input is within valid range

        */
        if ((range >= 5) && (range <= 21)){
            return true;
        }
        return false;
    }
    public static void printBox(int range){
        /*

        This method will print the characters as a box if the user input range is accepted.

        */
        System.out.print("What character? ");
        char value = in.next().charAt(0);
        System.out.println();
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                if (i == 1 || i == range || j == 1 || j == range)
                    System.out.print(value);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}