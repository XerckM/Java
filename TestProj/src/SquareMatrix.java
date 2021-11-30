import java.util.Scanner;
class SquareMatrix {
    public static void main(String[] args){
        char ans;
        Scanner in = new Scanner(System.in);
        String prompt = "Enter the size of the square matrix (positive & odd): ";
        do{
            int size = getValue(in, prompt);
            while (size % 2 == 0 || size < 1){ // this catches the errors for even and negative integers
                System.out.println("INPUT ERROR!! Invalid size.");
                size = getValue(in, prompt);
            }
            int[][] board = matrix(size);
            printMatrix(board, size);
            System.out.print("Do you want to continue (Y/N): ");
            ans = in.next().charAt(0);
        } while (ans== 'y' || ans == 'Y');
    }
    public static int getValue(Scanner in, String prompt){
        System.out.print(prompt);
        while(!in.hasNextInt()){ // this will catch errors for inputs that aren't integers
            in.next();
            System.out.println("INPUT ERROR!! Invalid size. ");
            System.out.print(prompt);
        }
        return in.nextInt();
    }
    public static int[][] matrix(int size){ // this constructs the n * n square matrix
        int[][] matrix = new int[size][size];
        int row = 0;
        int col = size/2;
        int num = 1;
        while (num <=  size * size){
            matrix[row][col] = num;
            num++;
            int tempCol = (col + 1) % size;
            int tempRow = (row - 1) >= 0 ? row - 1 : size - 1;
            if (matrix[tempRow][tempCol] != 0){
                row = (row + 1) % size;
            }
            else{
                row = tempRow;
                col = tempCol;
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix, int size){ // this method prints the matrix
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
 
