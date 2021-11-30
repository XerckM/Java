import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
class TwoDimensionalArray{
    private static final int MAX = 2;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean isComplete = false;
        System.out.print("Do you want to start (y/n): ");
        char ans = in.next().charAt(0);
        while (!isComplete){
            if (ans == 'y' || ans == 'Y'){
                System.out.print("How many rows: ");
                int row = getInt(in);
                while (row < 1){
                    System.out.print("Invalid input. ");
                    System.out.print("How many rows: ");
                    row = getInt(in);
                }
                System.out.print("How many columns: ");
                int col = getInt(in);
                while (col < 1){
                    System.out.print("Invalid input. ");
                    System.out.print("How many rows: ");
                    col = getInt(in);
                }
                int[][] matrix = new int[row][col];
                initRand(matrix, row, col, MAX);
                print(matrix);
                flipped(matrix);
                System.out.println();
                System.out.print("Do you want to continue (y/n): ");
                ans = in.next().charAt(0);
            }
            else if(ans == 'n' || ans == 'N'){
                isComplete = true;
            }
            else{
                System.out.println("Invalid input.");
                System.out.print("Do you want to continue (y/n): ");
                ans = in.next().charAt(0);
            }
        }
        System.out.println("Testing completed.");
    }
    public static void initRand(int[][] matrix, int row, int col, int MAX){
        Random rand = new Random();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
               matrix[i][j] = rand.nextInt(MAX);
            }
        }
    }
    public static void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            System.out.print("[" + i + "]");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void flipped(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        boolean isFlipped = true;
        for(int i = 0; i < rowSize; i++){
            int m = i + 1;
            while(m < rowSize){
                isFlipped = true;
                int j = 0;
                int k = colSize - 1;
                while (k >= 0 && j < colSize){
                    if (matrix[i][j] != matrix[m][k]){
                        isFlipped = false;
                        break;
                    }
                    j++;
                    k--;
                }
                if(isFlipped){
                    System.out.println("Row index " + i + " and " + m + " are flipped");
                }
            m++;
            }
        }
    }
    public static int getInt(Scanner in){
        while(!in.hasNextInt()){ // this will catch errors for inputs that aren't integers
            try{
                in.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Not an integer! Try again. ");
                in.next();
            }
        }
        return in.nextInt();
    }
}