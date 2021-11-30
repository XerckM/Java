import java.util.Scanner;
import java.util.Random;
class OneDimensionalArray{
    private static final int MIN = 1;
    private static final int MAX = 100;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean isComplete = false;
        System.out.print("Start (y/n): ");
        char ans = in.next().charAt(0);
        while (!isComplete){
            if (ans == 'y' || ans == 'Y'){
                String prompt = "How many elements in the list: ";
                int size = getInt(in, prompt);
                while (size < 1){
                    System.out.println("Negative size is invalid! Try again.");
                    size = getInt(in, prompt);
                }
                int[] array = new int[size];
                initRand(array, size, MIN, MAX);
                System.out.println("The original array is: ");
                print(array, size);
                int[] newArray = twice(array, size);;
                System.out.println("The second array is: ");
                print(newArray, 2 * size);
                System.out.print("Continue (y/n): ");
                ans = in.next().charAt(0);
            }
            else if(ans == 'n' || ans == 'N'){
                isComplete = true;
            }
            else{
                System.out.println("Invalid input.");
                System.out.print("Start (y/n): ");
                ans = in.next().charAt(0);
            }
        }
        System.out.println("Testing completed.");
    }
    public static void initRand(int[] array, int size, int MIN, int MAX){
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(MAX);
            if (array[i] < MIN){
                array[i] = rand.nextInt(MAX);
            }
        }
    }
    public static void print(int[] array, int size){
        for (int i = 0; i < size; i++){
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
    public static int[] twice(int[] array, int size){
        int[] twice = new int[2 * size];
        for (int i = 0; i < 2 * size; i += 2){
            twice[i] = array[i/2];
            twice[i+1] = twice [i];
        }
        return twice;
    }
    public static int getInt(Scanner in, String prompt){
        System.out.print(prompt);
        while(!in.hasNextInt()){ // this will catch errors for inputs that aren't integers
            in.next();
            System.out.println("Not an integer! Try again.");
            System.out.print(prompt);
        }
        return in.nextInt();
    }
}