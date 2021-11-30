import java.util.Scanner;
public class DrawSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        char ans;
        int row = 0;
        String promptRow = "How many chars/last row? ";
        char output;

        System.out.print("Do you want to start (Y/N): ");
        ans = in.next().charAt(0);
        
        while (ans == 'Y' || ans == 'y') {
            System.out.print(promptRow);
            row = getInt(in, promptRow);
    
            while (row < 5 || row > 21) {
                System.out.print("ERROR! Valid range 5 - 21. " + promptRow);
                row = getInt(in, promptRow);
            }
            System.out.print("What character? ");
            output = in.next().charAt(0);
    
            for (int i = 0; i < row; i++) {
                System.out.print(output);
            }
            System.out.println();
    
            for (int i = 0; i < row - 2; i++) {
                System.out.print(output);
                for (int j = 0; j < row - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print(output);
                System.out.println();
            }
            for (int i = 0; i < row; i++) {
                System.out.print(output);
            }
            System.out.println();
            System.out.println();
            System.out.print("Do you want to continue (Y/N): ");
            ans = in.next().charAt(0);
        }
    }
    public static int getInt(Scanner input, String prompt){
        while(!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again! " + prompt);
        }
        return input.nextInt();
    }
}