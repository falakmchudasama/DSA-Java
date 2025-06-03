import java.util.Deque;
import java.util.LinkedList;

class DQStack {
    private Deque<Integer> stack;

    public DQStack() {
        stack = new LinkedList<>();
    }

    public void push(int val){
        stack.addLast(val);
    }
    public void pop(){
        stack.removeLast();
    }
    public int top(){
        return stack.getLast();
    }
    public void printStack(){
        Deque<Integer> temp = stack;
        while(!temp.isEmpty()){
            System.out.print(temp.removeLast() + " ");
        }
        System.out.println();
    }
}

class DQueue {
    private Deque<Integer> queue;

    public DQueue(){
        queue = new LinkedList<>();
    }

    public void enque(int val){
        queue.addLast(val);
    }

    public void dequeue(){
        queue.removeFirst();
    }

    public int top(){
        return queue.peek();
    }

    public void printQueue(){
        Deque<Integer> temp = queue;
        while(!temp.isEmpty()){
            System.out.print(temp.removeFirst() + " ");
        }
        System.out.println();
    }

}

public class QDeque {
    public static void main(String[] args) {
        DQStack stack = new DQStack();
        DQueue queue = new DQueue();
        for(int i = 1; i <= 10; i++){
            stack.push(i);
            queue.enque(i);
        }
        queue.dequeue();
        stack.pop();

        queue.enque(11);
        stack.push(11);

        queue.printQueue();
        stack.printStack();
    }
}
