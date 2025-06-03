import java.util.LinkedList;
import java.util.Queue;

class StackUsingTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int val) {
        queue2.add(val);

        // Move elements from mainQueue to tempQueue
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Swap the names of the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public void pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        queue1.poll();
    }

    public void printStack() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for (int element : queue1) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class STwoQueues {
    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.push(6);
        stack.printStack();
    }
}
