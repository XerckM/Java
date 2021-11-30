public class UnorderedLinkedListInt extends LinkedListIntClass{
    public UnorderedLinkedListInt(){
        super();
    }
    public boolean search(int searchItem){
        LinkedListNode current;
        current = first;
        while(current != null){
            if(current.info == searchItem){
                return true;
            }
            else{
                current = current.link;
            }
        }
        return false;
    }
    public void insertFirst(int newItem){
        LinkedListNode newNode;
        newNode = new LinkedListNode(newItem, first);
        first = newNode;
        if(last == null){
            last = newNode;
        }
        count++;
    }
    public void insertLast(int newItem){
        LinkedListNode newNode;
        newNode = new LinkedListNode(newItem, null);
        if(first == null){
            first = newNode;
            last = newNode;
        }
        else{
            last.link = newNode;
            last = newNode;
        }
        count++;
    }
    public void deleteNode(int deleteItem){
        LinkedListNode current;
        LinkedListNode trailCurrent;
        boolean found;
        if(first == null){
            System.err.println("Can't delete from an empty list.");
        }
        else{
            if(first.info == deleteItem){
                first = first.link;
                if(first ==null){
                    last = null;
                }
                count++;
            }
            else{
                found = false;
                trailCurrent = first;
                current = first.link;
                while(current != null && !found){
                    if(current.info == deleteItem){
                        found = true;
                    }
                    else{
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                if(found){
                    count--;
                    trailCurrent.link = current.link;
                    if(last == current){
                        last = trailCurrent;
                    }
                }
                else{
                    System.out.println("Item is not in the list.");
                }
            }
        }
    }
    public int findSum(){
        LinkedListNode currentNode = first;
        int sum = 0;
        while(currentNode != null){
            sum += currentNode.info;
            currentNode = currentNode.link;
        }
        return sum;
    }
    public int findMin(){
        LinkedListNode currentNode = first;
        int min = first.info;
        while(currentNode != null){
            if(min > currentNode.info){
                min = currentNode.info;
            }
            currentNode = currentNode.link;
        }
        return min;
    }
    public String toString(){
        LinkedListNode currentNode = first;
        String str = "[";
        while(currentNode != null){
            if(currentNode.link != null){
                str += currentNode.info + ", ";
            }
            else{
                str += currentNode.info;
            }
            currentNode = currentNode.link;
        }
        return str += "]";
    }
}