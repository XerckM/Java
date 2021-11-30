import java.util.*;
public class Matrix{
    private int MAX = 20;
    private int [][] matrix = new int [MAX][MAX];
    private int size;
    /**
     * Constructor for objects of class Matrix
     */
    public Matrix(){
        size = 1;
    }
    public Matrix(int s){
        size = s;
    }
    public int getSize(){
        return size;
    }
    public int getElement(int r, int c){
        return matrix[r][c];
    }
    public void setElement(int r, int c, int value){
        matrix[r][c] = value;
    }
    public void init(int low, int up)
    {
        Random rand = new Random();
        for(int i = 0; i< size; i++)
            for(int j = 0; j< size; j++)
                matrix[i][j] = rand.nextInt(up - low + 1) + low;
    }
    public void print(){
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                System.out.printf("%5d", matrix[r][c]);
            }
            System.out.println();
        }
    }
    public Matrix add(Matrix a)
    {
        Matrix result = new Matrix(size);
        for(int i = 0; i< size; i++){
            for(int j = 0; j< size; j++){
                result.matrix[i][j] = matrix[i][j] + a.matrix[i][j];
            }
        }
        return result;
    }
    public Matrix subtract(Matrix a){
        Matrix result= new Matrix(size);
        for(int i = 0; i< size; i++){
            for(int j = 0; j< size; j++){
                result.matrix[i][j] = matrix[i][j] - a.matrix[i][j];
            }
        }
        return result;
    }
    public Matrix multiply(Matrix a){
        Matrix result = new Matrix(size);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    result.matrix[i][j] += matrix[i][k] * a.matrix[k][j];
                }
            }
        }
        return result;
    }
    public Matrix multConstant(int constant){
        Matrix result= new Matrix(size);
        for(int i = 0; i< size; i++){
            for(int j = 0; j< size; j++){
                result.matrix[i][j]= constant * matrix[i][j];
            }
        }
        return result;
    }
    public Matrix transpose(){
        Matrix trans = new Matrix(size);
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                trans.matrix[r][c] = matrix[c][r];
            }
        }
        return trans; 
    }
    public int trace(){
        int trace = 0;
        for(int k = 0; k < size; k ++){
            trace += matrix[k][k];
        }
        return trace; 
    }
    public boolean equals(Matrix a){
        if(size != a.size){
            return false;
        }
        else{
            for(int i=0; i < size; i++){
                for(int j=0; j < size; j++){
                    if(matrix[i][j] != a.matrix[i][j]){
                    return false;
                    }
                }
            }
        }
        return true;
    }
    public void copy(Matrix a){
        size = a.size;
        for(int i = 0; i < MAX; i++){
            for(int j = 0; j < MAX; j++){
                matrix[i][j] = a.matrix[i][j];
            }
        }
    }
    public Matrix getCopy(){
        Matrix temp = new Matrix(size);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp.matrix[i][j] = matrix[i][j];
            }
        }
        return temp;
    }
}