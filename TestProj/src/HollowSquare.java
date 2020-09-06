import java.util.*;

public class HollowSquare {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        char ans;
        boolean init = true;
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to create a hollow box (Y/N)? ");
        ans = in.next().charAt(0);
        do{
            if ((ans == 'Y') || (ans == 'y')){
                int range = getRange();
                printBox(range);
                System.out.println();
            }
            else if ((ans == 'N') || (ans == 'n')){
                in.close();
                break;
            }
            else{
                System.out.println("Only answer with 'Y' or 'y' for Yes, and 'N' or 'n' for No.");
            }
            System.out.print("Do you want to create a hollow box (Y/N)? ");
            ans = in.next().charAt(0);
        } while (init);
    }
    public static int getRange(){
        int range = 0;
        boolean valid = false;
        System.out.print("How many chars/last row? ");
        do{
            try{
                range = in.nextInt();
                if (isValidRange(range) == true){
                    valid = true;
                    return range;
                }
                else{
                    System.out.print("ERROR! Valid range 5 - 21. How many chars/last row? ");
                }
            } catch (InputMismatchException e){
                System.out.print("Not an integer! Try again! How many chars/last row? ");
                in.next();
            }
        } while (!valid);
        return range;
    }
    public static boolean isValidRange(int range){
        if ((range >= 5) && (range <= 21)){
            return true;
        }
        return false;
    }
    public static void printBox(int range){
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