import java.util.*;

public class ArraysPartOne {
    public static final int MAX = 100;
    public static final int MIN = 1;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String elemPrompt = "How many elements/list: ";
        System.out.print(elemPrompt);
        int elem = getInt(in, elemPrompt);
        int[] array = new int[elem];
        for (int i = 0; i < array.length; i++){
            array[i] = initRand();
        }
        System.out.println("The list is: ");
        print(array);

        System.out.println();
        int option = menu();
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
                    option = menu();
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
                    option = menu();
                    break;
                }
                case 3:{
                    System.out.println("The minimum gap between 2 adjacent values is " + minGap(array));
                    System.out.println();
                    option = menu();
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
                    option = menu();
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
                    option = menu();
                    break;
                }
                default:{
                    System.out.println();
                    option = menu();
                    break;
                }
            }
        }
        System.out.println("Testing completed.");
    }
    public static int initRand() {
        Random rand = new Random();
        int num = rand.nextInt(MAX-MIN) + MIN;
        return num;
    }
    public static int getInt(Scanner input, String prompt){
        while(!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again! " + prompt);
        }
        return input.nextInt();
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
                System.out.print(i + " ");
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
    public static double getVariance(int[] array, double mean){
        int size = array.length;
        double temp = 0;
        for(double a: array)
            temp += (a-mean)*(a-mean);
        return temp/(size-1);
    }
    public static int menu(){
        Scanner in = new Scanner(System.in);
        String prompt = "Please enter your option: ";
        System.out.println("Your options are: \n" +
        "----------------- \n" +
        "1) All even values? \n" +
        "2) All unique values? \n" +
        "3) Print min gap between values \n" +
        "4) Statistics \n" +
        "5) Print 80% percentile \n" +
        "0) EXIT");
        System.out.print(prompt);
        int choice = getInt(in, prompt);
        return choice;
    }
}