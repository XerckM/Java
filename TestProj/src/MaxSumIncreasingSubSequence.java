import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;

public class MaxSumIncreasingSubSequence {
    public static void main(String[] args) throws Exception {
        int i = 0;
        Scanner file = new Scanner(new File("input-5.2.txt")); //CHANGE THE INPUT NUMBER HERE!
        int[] input = new int[file.nextInt()];
        while(file.hasNext()){
            input[i] = file.nextInt();
            i++;
            //System.out.println(Arrays.deepToString(input));
        }
        int len = input.length;
        //System.out.println(getMaxSum(input, len));
        printMaxSequence(input, len);
    }
    /*public static int getMaxSum(int[] arr, int len) {
        if (len == 0) {
            return 0;
        }
        int[] sum = new int[len];
        sum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] < sum[j] && arr[i] > arr[j]) {
                    sum[i] = sum[j];
                }
            }
            sum[i] += arr[i];
        }
        return Arrays.stream(sum).max().getAsInt();
    }*/
    public static void printMaxSequence(int[] arr, int len) {
        if (len == 0) {
            return;
        }
        List<List<Integer>> maxSequence = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            maxSequence.add(i, new ArrayList<>());
        }
        maxSequence.get(0).add(arr[0]);
        int[] sum = new int[len];
        sum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] < sum[j] && arr[i] > arr[j]) {
                    maxSequence.set(i, new ArrayList<>(maxSequence.get(j)));
                    sum[i] = sum[j];
                }
            }
            maxSequence.get(i).add(arr[i]);
            sum[i] += arr[i];
        }
        int j = 0;
        for (int i = 1; i < len; i++){
            if (sum[i] > sum[j]) {
                j = i;
            }
        }
        System.out.println(Arrays.stream(sum).max().getAsInt() + "\n" + 
            Arrays.toString(maxSequence.get(j).toArray()).replace("[", "").replace(",", "").replace("]", ""));
    }
}