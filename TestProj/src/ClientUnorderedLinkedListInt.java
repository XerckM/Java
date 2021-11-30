import java.util.*;
public class ClientUnorderedLinkedListInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UnorderedLinkedListInt intList = new UnorderedLinkedListInt();
        UnorderedLinkedListInt tempList;
        int num;
        System.out.println("Enter integers (999 to stop)");
        num = input.nextInt();//valid??
        while (num != 999) {
            intList.insertLast((Integer) num);
        num = input.nextInt();//valid??
        }
        System.out.print("\nTesting .insertLast and .print. The original list is: ");
        intList.print();
        System.out.println("\nTesting .length. The length of the list is: " + intList.length());
        intList.print();
        System.out.println("\nTesting .length. The length of the list is: " + intList.length());
        System.out.println("Testing .sum. The sum of data in all nodes is: " + intList.findSum());
        System.out.println("Testing .min. The smallest data in all nodes is: " + intList.findMin());
        System.out.print("Testing .search. Enter the number to search for/list: ");
        num = input.nextInt(); //valid??
        if (intList.search(num))
            System.out.println(num + " found in this list.");
        else
            System.out.println(num + " is not in this list.");
        System.out.print("Testing .remove. Enter the number to be deleted from list: ");
        num = input.nextInt();//valid??
        intList.deleteNode(num);
        System.out.print("Testing .toString. After deleting " + num + ", the list is: " + intList);
        System.out.println("\nThe length of the list after delete is: " + 
        intList.length());
    }
}