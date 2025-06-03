import java.util.Stack;

class Queue3 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // stack1 is gonna store elements
    public Queue3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    private void moveTo2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    private void moveTo1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void enque(int val) {
        if (stack1.isEmpty()) {
            stack1.push(val);
            return;
        }
        moveTo2();
        stack2.push(val);
        moveTo1();
    }

    public void dequeue() {
        stack1.pop();
    }

    public void printQueue() {
        Stack<Integer> temp = stack1;
        while (!temp.isEmpty()) {
            System.out.print(temp.peek() + " ");
            temp.pop();
        }
        System.out.println();
    }
}

public class QTwoStacks {
    public static void main(String[] args) {
        Queue3 queue = new Queue3();
        for (int i = 1; i <= 5; i++) {
            queue.enque(i);
        }
        queue.dequeue();
        queue.enque(6);
        queue.printQueue();
    }
}
