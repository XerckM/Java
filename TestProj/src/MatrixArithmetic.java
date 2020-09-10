import java.util.*;

public class MatrixArithmetic{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        options();
        int choice = getValue();
        System.out.println();
        while (choice != 0){
            switch (choice){
                case 1:{
                    int size = getSize();
                    int[][] firstMatrix = getMatrix(size);
                    int[][] secondMatrix = getMatrix(size);
                    System.out.println("First matrix is:");
                    printMatrix(firstMatrix, size);
                    System.out.println("Second matrix is:");
                    printMatrix(secondMatrix, size);
                    int[][] result = addMatrix(firstMatrix, secondMatrix, size);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result, size);
                    System.out.println();
                    System.out.println("Command number 1 completed.");
                    System.out.println();
                    options();
                    choice = getValue();
                    break;
                }
                case 2:{
                    int size = getSize();
                    int[][] firstMatrix = getMatrix(size);
                    int[][] secondMatrix = getMatrix(size);
                    System.out.println("First matrix is:");
                    printMatrix(firstMatrix, size);
                    System.out.println("Second matrix is:");
                    printMatrix(secondMatrix, size);
                    int[][] result = subMatrix(firstMatrix, secondMatrix, size);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result, size);
                    System.out.println();
                    System.out.println("Command number 1 completed.");
                    System.out.println();
                    options();
                    choice = getValue();
                    break;
                }
                case 3:{ // need Multiply 2 matrices
                    break;
                }
                case 4:{ // need Multiply matrix by a constant
                    break;
                }
                case 5:{ // need Transpose matrix
                    break;
                }
                case 6:{ // need Matrix trace
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }
    public static void options(){
        System.out.print("Your options are: \n" + 
        "----------------- \n" + 
        "1) Add two matrices \n" + 
        "2) Subtract 2 matrices \n" + 
        "3) Multiply 2 matrices \n" +
        "4) Multiply matrix by a constant \n" + 
        "5) Transpose matrix \n" + 
        "6) Matrix trace \n" + 
        "0) EXIT \n" +
        "Please enter your option: ");
    }
    public static int getValue(){
        return in.nextInt();
    }
    public static int getSize(){
        System.out.print("Enter the size of square matrices: ");
        int size = getValue();
        return size;
    }
    public static int[][] getMatrix(int size){
        int[][] matrix = new int[size][size];
        randMatrix(matrix, size);
        return matrix;
    }
    public static void randMatrix(int[][] matrix, int size){
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
               matrix[i][j] = rand.nextInt(10);
            }
        }
    }
    public static void printMatrix(int[][] matrix, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
               System.out.print(matrix[i][j] + "\t"); // need to fix this print to printf to align output of matrix
            }
            System.out.print("\n");
        }
    }
    public static int[][] addMatrix(int[][] firstMatrix, int[][] secondMatrix, int size){
        int[][] add = new int[size][size];
        for(int i = 0; i < size; i++){    
            for(int j = 0; j < size; j++){    
                add[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return add;
    }
    public static int[][] subMatrix(int[][] firstMatrix, int[][] secondMatrix, int size){
        int[][] sub = new int[size][size];
        for(int i = 0; i < size; i++){    
            for(int j = 0; j < size; j++){    
                sub[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return sub;
    }
}