import java.util.ArrayList;
public class Lab9_2 {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList <Integer>();
        list.add(2);
        list.add(4);
        list.add(-2);
        list.add(5);
        list.add(3);
        list.add(0);
        list.add(7);
        System.out.println("The original list is: ");
        print(list);
        System.out.println("The list after method call is: ");
        scaleByK(list);
        print(list);
    } 
    public static void scaleByK(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i += list.get(i)) {
            if (list.get(i) < 0 || list.get(i) == 0) {
                list.remove(i);
                size--;
            }
            for (int j = 1; j < list.get(i); j++) {
                list.add(i + j, list.get(i));
                size++;
            }
        }
        for(int i = 0;i < list.size();i++){
            System.out.print(list.get(i) + " ");
        }
    }
    public static void print(ArrayList <Integer> someList) {
        for(Integer i:someList)
            System.out.print(i + " ");
        System.out.println();
    }
}