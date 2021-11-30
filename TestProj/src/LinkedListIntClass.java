import java.util.*;
public abstract class LinkedListIntClass implements LinkedListIntADT{
    protected class LinkedListNode{
        public int info;
        public LinkedListNode link;
        public LinkedListNode(){
            info = 0;
            link = null;
        }
        public LinkedListNode(int elem, LinkedListNode ptr){
            info = elem;
            link = ptr;
        }
    }
    protected LinkedListNode first;
    protected LinkedListNode last;
    protected int count;
    public LinkedListIntClass(){
        first = null;
        last = null;
        count = 0;
    }
    public boolean isEmptyList(){
        return first == null;
    }
    public void initializeList(){
        first = null;
        last = null;
        count = 0;
    }
    public void print(){
        LinkedListNode current;
        current = first;
        while(current != null){
            System.out.print(current.info + " ");
            current = current.link;
        }
    }
    public int length(){
        return count;
    }
    public int front(){
        return first.info;
    }
    public int back(){
        return last.info;
    }
    static boolean isSorted(LinkedListNode ptr) {
        if (ptr == null || ptr.link == null)
            return true;
        return ((ptr.info > ptr.link.info && isSorted(ptr.link)) || (ptr.info < ptr.link.info && isSorted(ptr.link)));
    }
    public abstract boolean search(int searchItem);
    public abstract void insertFirst(int newItem);
    public abstract void insertLast(int newItem);
    public abstract void deleteNode(int deleteItem);
}