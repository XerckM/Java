import java.util.*;

public class ArraysPartOne{
    private static Scanner in = new Scanner(System.in);
    private static final int[] array = initRand();
    public static void main(String[] args){
        System.out.println("The list is: ");
        print(array);
        System.out.println();
        menu();
    }
    private static int[] initRand(){
        boolean isEmpty = true;
        int size = 0;
        while (isEmpty){
            System.out.print("How many elements/list: ");
            try{
                size = in.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Not an integer! Try again! ");
                in.next();
            }
            if (size > 0){
                isEmpty = false;
            }
        }
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100);
        }
        return array;
    }
    private static int getInt(){
        boolean isNotEnabled = false;
        int value = 0;
        do{
            try{
                System.out.print("Please enter your option: ");
                value = in.nextInt();
                isNotEnabled = true;
            } catch (InputMismatchException e){
                System.out.print("Not an integer! Try again! ");
                in.next();
            }
        } while(!isNotEnabled);
        return value;
    }
    private static boolean isAllEven(int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }
    private static void print(int[] array){
        for (int i: array){
            if (i != 0){
                System.out.print(i + "\t");
            }
        }
        System.out.println();
    }
    private static boolean isUnique(int[] array){
        Set<Integer> unique = new HashSet<Integer>();
        for (int i :array){
          if (unique.contains(i)){
              return true;
          }
          unique.add(i);
        }
        return false;
    }
    private static int minGap(int[] array){
        int min = 100;
        for (int i = 1; i < array.length; i++){
            int gap = Math.abs(array[i] - array[i-1]);
            if (min > gap){
                min = gap;
            }
        }
        return min;
    }
    private static void bubbleSort(int[] array) 
    { 
        for (int i = 0; i < array.length-1; i++) 
            for (int j = 0; j < array.length-i-1; j++) 
                if (array[j] > array[j+1]) 
                { 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                } 
    }
    private static int[] copy(int[] array){
        int[] newArray = array.clone();
        return newArray;
    }
    private static int[] top_20(int[] array){
        int[] copy = copy(array);
        bubbleSort(copy);
        int size = (int)(copy.length * 0.2); // size is 20% of array
        int start = (int)(copy.length * 0.8); // start at the 80th percentile
        int[] top20 = new int[size + 1];
        for(int i = start; i < copy.length; i++){
            top20[i - start] = copy[i];
        }
        return top20;
    }
    private static double getMean(int[] array) {
        double total = 0;
        for (double d: array) {
            total += d;
        }
        return total / (array.length);
    }
    private static double getVariance(int[] array, double mean){
        int size = array.length;
        double temp = 0;
        for(double a: array)
            temp += (a-mean)*(a-mean);
        return temp/(size-1);
    }
    private static void printOptions(){
        System.out.println("Your options are: \n" +
        "----------------- \n" +
        "1) All even values? \n" +
        "2) All unique values? \n" +
        "3) Print min gap between values \n" +
        "4) Statistics \n" +
        "5) Print 80% percentile \n" +
        "0) EXIT");
    }
    private static void menu(){
        printOptions();
        int option = getInt();
        while (option != 0){
            switch (option){
                case 1:{
                    if (isAllEven(array) == true){
                        System.out.println("All values are even.");
                    }
                    else{
                        System.out.println("Some values/list are odd.");
                    }
                    System.out.println();
                    printOptions();
                    option = getInt();
                    break;
                }
                case 2:{
                    if (isUnique(array) == true){
                        System.out.println("Some values/list appear multiple times ");
                    }
                    else{
                        System.out.println("All values are unique.");
                    }
                    System.out.println();
                    printOptions();
                    option = getInt();
                    break;
                }
                case 3:{
                    System.out.println("The minimum gap between 2 adjacent values is " + minGap(array));
                    System.out.println();
                    printOptions();
                    option = getInt();
                    break;
                }
                case 4:{
                    double mean = getMean(array);
                    double variance = getVariance(array, mean);
                    System.out.println();
                    System.out.println("The statistics for this list:");
                    print(array);
                    System.out.printf("The mean for this list is: %.02f\n", mean);
                    System.out.printf("The variance for this list is: %.02f\n", variance);
                    System.out.printf("The standard deviation for this list is: %.02f\n", Math.sqrt(variance));
                    System.out.println();
                    printOptions();
                    option = getInt();
                    break;
                }
                case 5:{
                    int[] copy = copy(array);
                    bubbleSort(copy);
                    System.out.println("The list sorted:");
                    print(copy);
                    System.out.println("80%-percentile from this list:");
                    print(top_20(array));
                    System.out.println();
                    printOptions();
                    option = getInt();
                    break;
                }
                default:{
                    System.out.print("Testing Completed.");
                    break;
                }
            }
        }
    }   
}