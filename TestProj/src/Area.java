import java.util.Scanner;
import java.util.Stack;
import java.io.File;

public class Area {
    public static void main(String[] args) throws Exception {
        int i = 0;
        Scanner file = new Scanner(new File("input-4.1.txt")); //CHANGE THE INPUT NUMBER HERE!
        int[][] input = new int[file.nextInt()][2];
        while(file.hasNext()){
            input[i][0] = file.nextInt();
            input[i][1] = file.nextInt();
            i++;
            //System.out.println(Arrays.deepToString(input));
        }
        System.out.println("The maximum area is " + getArea(input, input.length));
    }
    /**
     * Returns the largest rectangular area of a group of histograms
     * @param input int[]
     * @param length input size
     * @return int of maximum area
     */
    private static int getArea(int[][] input, int length) {
        Stack<Integer> stack = new Stack<>();
        int maximumArea = 0, topOfStack, areaAndTop;
        int count = 0;
        while (count < length) {
            if (stack.empty() || input[stack.peek()][1] <= input[count][1]) {
                stack.push(count++);
            }
            else {
                topOfStack = stack.peek();
                stack.pop();
                areaAndTop = input[topOfStack][1] * (stack.empty() ? input[count][0] : input[count][0] - input[(stack.peek())][0]);
                if (maximumArea < areaAndTop) {
                    maximumArea = areaAndTop;
                }
            }
        }
        return maximumArea;
    }
}