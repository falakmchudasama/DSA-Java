class Queue {
    private int queue[];
    int size;
    int head;
    int tail;

    public Queue(int n){
        queue = new int[n];
        size = 0;
        head = -1;
        tail = -1;
    }

    public void enque(int val){
        size++;
        if(head == -1){
            head = 0;
            tail = 0;
            queue[tail] = val;
            return;
        }
        tail++;
        queue[tail] = val;
    }

    public void deque(){
        if(head == tail){
            return;
        }
        head++;
        size--;
    }

    public int peek(){
        return queue[tail];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return tail == -1;
    }

    public void printQueue(){
        for(int i = head; i <= tail; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class QArray {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        for(int i = 1; i <= 5; i++){
            queue.enque(i);
        }
        queue.deque();
        queue.enque(6);
        queue.printQueue();
    }
}
