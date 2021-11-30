import java.util.Scanner;
public class Client_SQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedStackClass<Character> s = new LinkedStackClass<Character>();
        QueueClass<Character> q = new QueueClass<Character>();
        boolean isNotValid = false;
        s.push('M');
        s.push('Z');
        s.push('A');
        s.push('T');
        s.push('C');
        s.push('V');
        f(s);
        printStack(s);
    }
    public static void f(LinkedStackClass<Character> s){
        if(!s.isEmptyStack()){
            Character next = s.peek();
            s.pop();
            f(s);
            s.push(next);
            s.push(next);
        }
    }
    public static void printBackStack(LinkedStackClass<Integer> intStack) {
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<Integer>();
        while (!intStack.isEmptyStack()) {
            System.out.print(intStack.peek() + " ");
            tempStack.push(intStack.peek());
            intStack.pop();
        }
        while (!tempStack.isEmptyStack()) {
            intStack.push(tempStack.peek());
            tempStack.pop();
        }
    }
    public static void printStack(LinkedStackClass<Character> intStack) {
        LinkedStackClass<Character> tempStack = new LinkedStackClass<Character>();
        while (!intStack.isEmptyStack()) {
            tempStack.push(intStack.peek());
            intStack.pop();
        }
        while (!tempStack.isEmptyStack()) {
            System.out.print(tempStack.peek() + " ");
            intStack.push(tempStack.peek());
            tempStack.pop();
        }
    }
    public static Integer getSecond(LinkedStackClass<Integer> intStack) {
        Integer top = intStack.peek();
        intStack.pop();
        Integer second = intStack.peek();
        intStack.push(top);
        return second;
    }
    public static int countItems(LinkedStackClass<Integer> intStack) {
        int ctr = 0;
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<Integer>();
        while (!intStack.isEmptyStack()) {
            ctr++;
            tempStack.push(intStack.peek());
            intStack.pop();
        }
        while (!tempStack.isEmptyStack()) {
            intStack.push(tempStack.peek());
            tempStack.pop();
        }
        return ctr;
    }  
    public static void removeItem(LinkedStackClass<Integer> intStack, Integer n) {
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<Integer>();
        while (!intStack.isEmptyStack()) {
            if (intStack.peek() == n) {
                intStack.pop();
            }
            else {
                tempStack.push(intStack.peek());
                intStack.pop();
            }
        }
        while (!tempStack.isEmptyStack()) {
            intStack.push(tempStack.peek());
            System.out.print(intStack.peek() + " ");
            tempStack.pop();
        }
    }
    public static void reverseStack(LinkedStackClass<Integer> s) {
        QueueClass<Integer> q = new QueueClass<Integer>();
        while (!s.isEmptyStack()) {
            q.enqueue(s.peek());
            s.pop();
            System.out.print(q.back() + " ");
        }
    } 
    public static void reverseQueue(QueueClass<Integer> q){
        LinkedStackClass<Integer> s = new LinkedStackClass<Integer>();
        while (!q.isEmptyQueue()) {
            s.push(q.front());
            q.dequeue();
        }
        printBackStack(s);
    }
    public static void printQueue(QueueClass<Integer> q) {
        QueueClass<Integer> tempQueue = new QueueClass<Integer>();
        while (!q.isEmptyQueue()) {
            if (q.front() < 0){
                tempQueue.enqueue(q.front());
                System.out.print(tempQueue.back() + " ");
                q.dequeue();
            }
        }
        while (!tempQueue.isEmptyQueue()) {
            q.enqueue(tempQueue.front());
            tempQueue.dequeue();
        }
    }
    public static int getInt(Scanner input, String prompt){
        while(!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again. " + prompt);
        }
        return input.nextInt();
    }
}