public class DoubleLinkedList<T> implements DoubleLinkedListADT<T>{
    public class DoubleLinkedListNode<T>{
        T info;
        DoubleLinkedListNode<T> next;
        DoubleLinkedListNode<T> back;
        public DoubleLinkedListNode(){
            info = null;
            next = null;
            back = null;
        }
        public String toString(){
            return info.toString();
        }
    }
    protected int count;
    protected DoubleLinkedListNode<T> first;
    protected DoubleLinkedListNode<T> last;
    public void initializeList(){
        first = null;
        last = null;
        count = 0;
    }
    public boolean isEmptyList(){
        if (first == null){
            return true;
        }
        else{
            return false;
        }
    }
    public T front(){
        return first.info;
    }
    public T back(){
        return last.info;
    }
    public int length(){
        return count;
    }
    public void print(){
        DoubleLinkedListNode<T> currentNode = first;
        while (currentNode != null){
            System.out.println(currentNode.info.toString() + " - ");
            currentNode = currentNode.next;
        }
    }
    public void reversePrint(){
        DoubleLinkedListNode<T> tempNode = last;
        while (tempNode != null){
            System.out.println(tempNode.info.toString() + " - ");
            tempNode = tempNode.back;
        }
    }
    public boolean search(T searchItem){
        DoubleLinkedListNode<T> tempNode = first;
        while (tempNode != null){
            if (tempNode.info.toString() == searchItem.toString()){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
    public void insertNode(T insertItem){
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
        newNode.info = insertItem;
        DoubleLinkedListNode<T> currentNode = first;
        DoubleLinkedListNode<T> previousNode = null;
        boolean found = false;
        if (first == null){
            first = newNode;
            last = newNode;
            count++;
        }
        else{
            while(currentNode != null && !found){
                Comparable<T> temp = (Comparable<T>) currentNode.info;
                if (temp.compareTo(insertItem) >= 0){
                    found = true;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode == first){
                newNode.next = first;
                first.back = newNode;
                first = newNode;
                count++;
            }
            else if (currentNode == null){
                previousNode.next = newNode;
                newNode.back = previousNode;
                last = newNode;
                count++;
            }
            else{
                previousNode.next = newNode;
                newNode.back = previousNode;
                newNode.next = currentNode;
                currentNode.back = newNode;
                count++;
            }
        }
    }
    public void deleteNode(T deleteItem){
        DoubleLinkedListNode<T> currentNode = first;
        DoubleLinkedListNode<T> previousNode = null;
        if (first.info.toString() == deleteItem.toString()){
            if (first == last){
                first = null;
                last = null;
                count = 0;
            }
            else{
                first = first.next;
                first.back = null;
                count--;
            }
        }
        else{
            while (currentNode != null){
                if (currentNode.info.equals(deleteItem)){
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null){
                if (currentNode == last){
                    last = last.back;
                    last.next = null;
                    count--;
                }
                else{
                    currentNode.next.back = previousNode;
                    previousNode.next = currentNode.next;
                    count--;
                }
            }
            else{
                System.out.println(deleteItem.toString() + " doesn't exist!");
            }
        }
    }
    private String recursiveToString(DoubleLinkedListNode<T> head){
        if (head == null){
            return "[tail]";
        }
        else{
            return head.info.toString() + " - " + recursiveToString(head.next);
        }
    }
    public String recursiveToString(){
        return recursiveToString(first);
    }
    public String backwardsString(){
        String tempString = "[tail] - ";
        DoubleLinkedListNode<T> tempNode = last;
        while (tempNode != null){
            tempString += tempNode.info.toString() + " - ";
            tempNode = tempNode.back;
        }
        return tempString + "[head]";
    }
    private String recursiveBackwardsString(DoubleLinkedListNode<T> tail){
        if (tail == null){
            return "";
        }
        else{
            return tail.info.toString() + " - " + recursiveBackwardsString(tail.back);
        }
    }
    public String recursiveBackwardsString(){
        return "[tail] - " + recursiveBackwardsString(last);
    }
    public void copy(DoubleLinkedList<T> otherList){
        DoubleLinkedListNode<T> newNode;
        DoubleLinkedListNode<T> currentNode = otherList.first;
        if (otherList.first == null){
            this.first =null;
            this.last = null;
            count = 0;
        }
        else{
            this.first = null;
            this.last = null;
            this.count = otherList.count;
            this.first = new DoubleLinkedListNode<T>();
            this.first.info = currentNode.info;
            this.first.next = null;
            this.last = this.first;
            currentNode = currentNode.next;
            while (currentNode != null){
                newNode = new DoubleLinkedListNode<T>();
                newNode.info = currentNode.info;
                newNode.back = this.last;
                this.last.next = newNode;
                this.last = newNode;
                currentNode = currentNode.next;
            }
        }
    }
    public void reversedCopy(DoubleLinkedList<T> otherList){
        DoubleLinkedListNode<T> newNode;
        DoubleLinkedListNode<T> currentNode = otherList.last;
        if (otherList.first == null){
            this.first =null;
            this.last = null;
            count = 0;
        }
        else{
            this.first = null;
            this.last = null;
            this.count = otherList.count;
            this.first = new DoubleLinkedListNode<T>();
            this.first.info = currentNode.info;
            this.first.next = null;
            this.last = this.first;
            currentNode = currentNode.back;
            while (currentNode != null){
                newNode = new DoubleLinkedListNode<T>();
                newNode.info = currentNode.info;
                newNode.back = this.last;
                this.last.next = newNode;
                this.last = newNode;
                currentNode = currentNode.back;
            }
        }
    }
    public String toString(){
        String tempString = "[head] - ";
        DoubleLinkedListNode<T> tempNode = first;
        while (tempNode != null){
            tempString += tempNode.info + " - ";
            tempNode = tempNode.next;
        }
        return tempString + "[tail]";
    }
}