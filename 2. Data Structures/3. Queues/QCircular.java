public class QCircular {

    static class Queue {
        private int queue[];
        private int size;
        private int head;
        private int tail;
    
        public Queue(int n) {
            queue = new int[n];
            size = 0;
            head = 0;
            tail = 0;
        }
    
        public void enque(int val) {
            if (size == queue.length) {
                System.out.println("Queue is full");
                return;
            }
            queue[tail] = val;
            tail = (tail + 1) % queue.length;
            size++;
        }
    
        public void deque() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }
            head = (head + 1) % queue.length;
            size--;
        }
    
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[(head + size - 1) % queue.length];
        }
    
        public int getSize() {
            return size;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(head + i) % queue.length] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.printQueue();
        queue.deque();
        queue.printQueue();
    }
}
