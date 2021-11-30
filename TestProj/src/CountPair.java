import java.util.Arrays;

public class CountPair {
    // Merge two sorted subarrays
    public static int mergeArr(int[] arr, int[] copy, int LOW, int MID, int HIGH) {
        int k = LOW, i = LOW, j = MID + 1;
        int ctr = 0;
        while (i <= MID && j <= HIGH) {
            if (arr[i] <= arr[j]) {
                copy[k++] = arr[i++];
            }
            else {
                copy[k++] = arr[j++];
                ctr += (MID - i + 1);
            }
        }
        while (i <= MID) {
            copy[k++] = arr[i++];
        }
        // copy back to the original array
        for (i = MID; i <= HIGH; i++) {
            arr[i] = copy[i];
        }
        return ctr;
    }
    // Sort array int[] arr using int[]copy
    public static int countPair(int[] arr, int[] copy, int low, int high) {
        // base case
        if (high <= low) {
            return 0;
        }
        // midpoint
        int mid = (low + ((high - low) >> 1));
        int ctr = 0;
        // split/merge left half
        ctr += countPair(arr, copy, low, mid);
        // split/merge right half
        ctr += countPair(arr, copy, mid + 1, high);
        // merge the two half runs
        ctr += mergeArr(arr, copy, low, mid, high);
        return ctr;
    }
    // Test O(n^2) to find pairs
    public static int testCountPair(int[] arr, int n) {
        int i = 0, j = 1;
        int ctr = 0;
        while (i < n) {
            if (j == n) {
                i++;
                j = 1;
            }
            else if (i < j && (arr[i] > arr[j])) {
                System.out.print("(" + arr[i] + "," + arr[j] +") ");
                ctr++; // Counting pairs
            }
            j++;
        }
        System.out.println();
        return ctr;
    }
    public static void main(String[] args) {
        int[] arr = {7, 3, 8, 1, 5};
        int len = arr.length;
        int[] copy = Arrays.copyOf(arr, len);
        System.out.println();
        System.out.println("The number of pairs using O(n^2) time complexity is " + testCountPair(arr, len));
        System.out.println("The number of pairs using O(n log n) time complexity is " + countPair(arr, copy, 0, len - 1));
    }
}