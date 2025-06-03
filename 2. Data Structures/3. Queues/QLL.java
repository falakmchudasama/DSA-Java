class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue2 {
    private Node front;
    private Node rear;

    public Queue2() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (isEmpty()) {
            return;
        }

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class QLL {
    public static void main(String[] args) {
        Queue2 queue = new Queue2();
        for(int i = 1; i <= 10; i++){
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.enqueue(11);
        queue.printQueue();
    }
}
