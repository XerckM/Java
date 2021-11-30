import java.util.ArrayList;
public class Lab9_4 {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList <Integer>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(9);
        list.add(9);
        System.out.println("The original list is: ");
        print(list);
        System.out.println("The list after method call is: ");
        removeDuplicates(list);
        print(list);
    }
    public static void removeDuplicates(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++)			
			for(int j = i + 1; j < list.size(); j++)
				if(list.get(i).compareTo(list.get(j)) == 0) {
					list.remove(j);
					j--;
				}
    }
    public static void print(ArrayList <Integer> someList) {
        for(Integer i:someList)
            System.out.print(i + " ");
        System.out.println();
    }
}