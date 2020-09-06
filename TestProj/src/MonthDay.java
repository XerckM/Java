import java.util.*;

public class MonthDay{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        int month;
        int day;
        char ans;
        String output;
        boolean isEnabled = true;
        System.out.print("Check season using month and day (Y/N)? ");
        ans = in.next().charAt(0);
        do{
            if ((ans == 'Y') || (ans == 'y')){ // the rest of the code executes when user inputs Y or y
                System.out.print(getMonth());
                month = getValue(getMonth());
                System.out.print(getDay(month));
                day = getValue(getDay(month));
                output = getSeason(month, day);
                System.out.println();
                System.out.println("You entered " + month + "/"+ day + " and it is in the " + output + " season!");
                System.out.println();
                System.out.print("Would you like to check another date (Y/N)? ");
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
    public static String getMonth(){
        return "Enter month (1-12): "; // used to automate raised error message in getValue
    }
    public static String getDay(int month){ // used to automate raised error message in getValue
        if ((month == 2)){
            return "Enter day (1-29): ";
        }
        else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)){
            return "Enter day (1-30): ";
        }
        return "Enter day (1-31): ";
    }
    public static int getValue(String prompt){
        int value = 0;
        boolean isEnabled = true;
        do{ // do-while loop to catch error InputMismatchException for non-integer characters
            try{
                value = in.nextInt();
                if (value < 0){
                    System.out.print("Invalid input. " + prompt);
                }
                else if (prompt.equals("Enter day (1-29): ") && (value > 29)){
                    System.out.print("February has only a maximum of 29 days. " + prompt);
                }
                else if (prompt.equals("Enter day (1-30): ") && (value > 30)){
                    System.out.print("This month has a maximum of 30 days. " + prompt);
                }
                else{
                    isEnabled = false;
                    return value;
                }
            } catch (InputMismatchException e){ // when non-integer character is passed it raises this error
                System.out.print("Not an integer! " + prompt);
                in.next();
            }
            if (prompt.equals("Enter day (1-29)")){
                
            }
        } while (isEnabled);
        return value;
    }
    public static String getSeason(int month, int day){ // calculates month and day into a single integer and returns the season value
        int monthDay = month * 100 + day;
        if (monthDay <= 315) {
            return "Winter";
        }
        else if (monthDay <= 615) {
            return "Spring";
        }
        else if (monthDay <= 915) {
            return "Summer";
        }
        else if (monthDay <= 1215) {
            return "Fall";
        }
        else {
            return "Winter";
        }
    }
}