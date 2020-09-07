import java.util.*;
public class DigitTest{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        boolean isEnabled = true;
        System.out.print("Enter a 2-digit number (different digits). Zero to stop: ");
        do{
            try{
                int src = getValue();
                if (src == 0){
                    isEnabled = false;
                }
                else if (!isLengthValid(src) || (src < 0)){
                    System.out.println("Not good for your game!");
                    System.out.print("Enter a 2-digit number (different digits). Zero to stop: ");
                }
                else{
                    if (isAdjacentValueSame(src)){
                        System.out.println("Not good for your game!");
                        System.out.print("Enter a 2-digit number (different digits). Zero to stop: ");
                    }
                    else{
                        System.out.println("Good for your game! Play!");
                        System.out.print("Enter a 2-digit number (different digits). Zero to stop: ");
                    }
                }
            } catch (InputMismatchException e){
                System.out.print("Not an integer, try again: ");
                in.next();
            }
        } while (isEnabled);
    }
    public static int getValue(){
        return in.nextInt();
    }
    public static boolean isAdjacentValueSame(int value){
        String len = Integer.toString(value);
        for (int i = 1; i < len.length(); i++){
            if (len.charAt(i) == len.charAt(i-1)){
                return true;
            }
        }
        return false;
    }
    public static boolean isLengthValid(int value){
        boolean valid = true;
        String len = Integer.toString(value);
        if ((len.length() < 2) || (len.length() > 2)){
            valid = false;
        }
        return valid;
    }
}