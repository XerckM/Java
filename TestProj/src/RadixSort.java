import java.util.Arrays;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RadixSort {
    /*
        Returns the value of the bit at index 'bit' in 'number'
    */
    private static int bitValue(int number, int bit) { // O(1)
        int mask = 1 << bit;
        if ((number & mask) != 0) {
            return 1;
        }
        return 0;
    }

    /*
        Arrange the items in theArray based on the value of
        a specific bit. This doesn't fully sort the array (it
        just sorts by a specific bit), but we'll use it for radix
        sort.
    */
    private static int[] countingSort(int[] theArray, int bit) { 
        int[] count = new int[]{0, 0};
        System.out.print("Count Values: ");
        for (int item : theArray) {
            count[bitValue(item, bit)] += 1;
            System.out.print(Arrays.toString(count) + " ");
        }
        System.out.println();
        int[] indices = new int[]{0, count[0]};
        System.out.print("Indices Values: \n");
        int[] sortedArray = new int[theArray.length];
        for (int item : theArray) {
            System.out.print(Arrays.toString(indices) + " ");
            int itemBitValue = bitValue(item, bit); 
            sortedArray[indices[itemBitValue]] = item;
            indices[itemBitValue] += 1;
            System.out.println(Arrays.toString(sortedArray) + " ");
        }
        System.out.println();
        return sortedArray;
    }

    /*
        Use counting sort to arrange the numbers, from least significant
        bit to most significant bit.
    */
    public static int[] radixSort2(int[] theArray) { //O(n*(n+k))
        for (int bitIndex = 0; bitIndex < 8; bitIndex++) { //O(n)
            System.out.println("Bit Index: " + bitIndex);
            theArray = countingSort(theArray, bitIndex); //O(n+k)
            System.out.println("Sorted Array by bit index: " + Arrays.toString(theArray));
            System.out.println();
        }
        return theArray;
    }
    
    /* 
        This radixSort is in base-16 and uses 16-bits which is hexadecimal
        Every 4-bits in hexadecimal is a value

        We will be using Bit Shifting
        "Bit Shifting" EX. 32 >> 4 
        -->> convert 32 to binary 100000
        -->> so we shift 4 to the right and the binary "100000" becomes "10"
        -->> which in decimal is "2"

        We will also use the bitwise "&" operator
        bitwise "&" is the same as the "&&" operator for boolean
        except we will be doing it in binary form.
        "Bitwise &" EX. 32 & 4 
        -->> convert 32 to binary 100000
        -->> convert 4 to binary 100
        -->> we the use the & operator which is the same as && in boolean
        -->>   100000
             & 000100
               ------
               000000
        -->> and value of 32 & 4 = 000000 which is just 0 in decimal
    */
    public static void radixSort16(int[] arr) {
        // we start our position at 0 which is the rightmost position in binary
        int rShift = 0; 
        int len = arr.length;
        int[] tempArr = new int[len];
        int max = 1;

        while (max >> rShift > 0) { // O(1) time complexity since the passes are shifted every 4 bits
            System.out.println("(Start Iteration)");
            // frequency array length is 16
            int[] count = new int[16];

            // we get the frequency count of each digits at current digit place by
            // bit shifting the item and bitwise & it to 15 
            for (int item : arr) {
                System.out.println(Arrays.toString(count));

                // we find the max on the first pass so that we can determine how many passes
                // it takes to sort the array
                if (rShift == 0) {
                    if (item > max) { 
                        max = item;
                    }
                }
                count[(item >> rShift) & 15]++;
            }
            for (int i = 1; i < 16; i++) { // O(n)
                System.out.println(Arrays.toString(count));
                count[i] += count[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) { // O(n)
                System.out.println(Arrays.toString(tempArr));
                int current = (arr[i] >> rShift) & 15;
                tempArr[count[current] - 1] = arr[i];
                count[current]--;
            }

            // instead of returning the array we are copying the contents of our temp array to the array itself which is O(n) time
            System.arraycopy(tempArr, 0, arr, 0, len);

            // Incrementing postion so we can bitshift by 4-bits for our while loop
            rShift += 4;
            System.out.println("(End Iteration)");
            System.out.println();
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try{
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);
            int[] arr = {45, 98, 3, 82, 132, 71, 72, 143, 91, 28, 7, 45};
            
            System.out.println("Final Sorted Array: " + Arrays.toString(radixSort2(arr)));

            //System.out.println("Array before radixSort: " + Arrays.toString(arr));
            //System.out.println();
            //radixSort16(arr);
            //System.out.println();
            //System.out.println("Array after radixSort: " + Arrays.toString(arr));
        }catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }
}