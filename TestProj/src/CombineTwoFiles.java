import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class CombineTwoFiles{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> mergedList = new ArrayList<Integer>();

        System.out.print("Please input the name of the file to be opened for first list: ");
        list1 = getArrayList();
        System.out.print("Please input the name of the file to be opened for second list: ");
        list2 = getArrayList();
        
        System.out.println("The first list is: " + list1);
        System.out.println("The second list is: " + list2);

        mergedList = merge(list1, list2);
        System.out.println("The merged list is: " + mergedList);

        bubbleSort(mergedList);
        System.out.println("The merged sorted list is: " + mergedList);

        System.out.print("Enter key for split: ");
        int key = getInt(in);

        split(mergedList, list1, list2, key);
        System.out.println("The first list after split is: " + list1);
        System.out.println("The second list after split is: " + list2);
    }
    private static ArrayList<Integer> getArrayList(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        try{
            String filename = in.next();
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNext()){
                if (inputFile.hasNextInt()){
                    arr.add(inputFile.nextInt());
                }
                else{
                    inputFile.next();
                }
            }
            inputFile.close();
        } catch (FileNotFoundException e){
            System.out.println();
            System.out.println("---File Not Found! Exit program!---");
            System.exit(0);
        }
        return arr;
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.addAll(list1);
        arr.addAll(list2);
        return arr;
    }
    public static void bubbleSort(ArrayList<Integer> list){
        Integer temp;
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < list.size()-1; i++){
                if (list.get(i).compareTo(list.get(i + 1)) > 0){
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }
    public static void split(ArrayList<Integer> mergedList, ArrayList<Integer> list1, ArrayList<Integer> list2, int key){
        list1.clear();
        list2.clear();
        for (int i = 0; i < mergedList.size(); i++){
            if (mergedList.get(i) <= key){
                list1.add(mergedList.get(i));
            }
            else{
                list2.add(mergedList.get(i));
            }
        }
    }
    public static int getInt(Scanner input){
        while(!input.hasNextInt())
        {
          input.next();
          System.out.print("ERROR!!! Not an integer. Try again. Enter key for split: ");
        }
        return input.nextInt();
    }
}