import java.util.*;

public class MatrixArithmetic{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        showOptions();
        int choice = getValue();
        System.out.println();
        while (choice != -1){
            switch (choice){
                case 1:{ // add two matrices
                    System.out.println();
                    int size = getSize();
                    int[][] firstMatrix = getMatrix(size);
                    int[][] secondMatrix = getMatrix(size);
                    System.out.println("First matrix is:");
                    printMatrix(firstMatrix);
                    System.out.println("Second matrix is:");
                    printMatrix(secondMatrix);
                    int[][] result = addMatrix(firstMatrix, secondMatrix, size);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result);
                    System.out.println("\n");
                    System.out.println("Command number 1 completed.");
                    System.out.println();
                    showOptions();
                    choice = getValue();
                    break;
                }
                case 2:{ // subtract two matrices
                    System.out.println();
                    int size = getSize();
                    int[][] firstMatrix = getMatrix(size);
                    int[][] secondMatrix = getMatrix(size);
                    System.out.println("First matrix is:");
                    printMatrix(firstMatrix);
                    System.out.println("Second matrix is:");
                    printMatrix(secondMatrix);
                    int[][] result = subMatrix(firstMatrix, secondMatrix, size);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result);
                    System.out.println("\n");
                    System.out.println("Command number 2 completed.");
                    System.out.println();
                    showOptions();
                    choice = getValue();
                    break;
                }
                case 3:{ // multiply two matrices
                    System.out.println();
                    int size = getSize();
                    int[][] firstMatrix = getMatrix(size);
                    int[][] secondMatrix = getMatrix(size);
                    System.out.println("First matrix is:");
                    printMatrix(firstMatrix);
                    System.out.println("Second matrix is:");
                    printMatrix(secondMatrix);
                    int[][] result = prodTwoMatrix(firstMatrix, secondMatrix, size);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result);
                    System.out.println("\n");
                    System.out.println("Command number 3 completed.");
                    System.out.println();
                    showOptions();
                    choice = getValue();
                    break;
                }
                case 4:{ // multiply matrix to a constant
                    System.out.println();
                    int size = getSize();
                    System.out.print("Enter the multiplication constant: ");
                    int constant = getValue();
                    int[][] matrix = getMatrix(size);
                    System.out.println("The matrix is:");
                    printMatrix(matrix);
                    int[][] result = prodMatrixConstant(matrix, size, constant);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result);
                    System.out.println("\n");
                    System.out.println("Command number 4 completed.");
                    System.out.println();
                    showOptions();
                    choice = getValue();
                    break;
                }
                case 5:{ // transpose matrix
                    System.out.println();
                    int size = getSize();
                    int[][] matrix = getMatrix(size);
                    System.out.println("The matrix is:");
                    printMatrix(matrix);
                    int[][] result = transposeMatrix(matrix, size);
                    System.out.println("The resulting matrix is:");
                    printMatrix(result);
                    System.out.println("\n");
                    System.out.println("Command number 5 completed.");
                    System.out.println();
                    showOptions();
                    choice = getValue();
                    break;
                }
                case 6:{ // trace matrix
                    System.out.println();
                    int size = getSize();
                    int[][] matrix = getMatrix(size);
                    System.out.println("The matrix is:");
                    printMatrix(matrix);
                    int result = traceMatrix(matrix, size);
                    System.out.print("The trace for this matrix is: " + result);
                    System.out.println("\n");
                    System.out.println("Command number 6 completed.");
                    System.out.println();
                    showOptions();
                    choice = getValue();
                    break;
                }
                default:{
                    System.out.println("Testing completed.");
                    choice = -1;
                    break;
                }
            }
        }
    }
    public static void showOptions(){
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
    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
               System.out.printf("%4s", matrix[i][j] + "\t");
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
    public static int[][] prodTwoMatrix(int[][] firstMatrix, int[][] secondMatrix, int size){
        int[][] product = new int[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }
    public static int[][] prodMatrixConstant(int[][] matrix, int size, int constant){
        int[][] product = new int[size][size];
        for(int i = 0; i < size; i++){    
            for(int j = 0; j < size; j++){    
                product[i][j] = matrix[i][j] * constant;
            }
        }
        return product;
    }
    public static int[][] transposeMatrix(int[][] matrix, int size){
        int[][] newMatrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
               newMatrix[i][j] = 0;
               for(int k = 0; k < size; k++){
                  newMatrix[i][j] = matrix[j][i];
               }
            }
        }
        return newMatrix;
    }
    public static int traceMatrix(int[][] matrix, int size){
        int trace = 0; 
        for (int i=0; i < size; i++){
            trace += matrix[i][i];
        }
        return trace; 
    }
}