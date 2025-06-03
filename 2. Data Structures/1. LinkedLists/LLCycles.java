public class LLCycles {

    static class Node {
        int data;
        Node next;
        public Node (int value){
            this.data = value;
            this.next = null;
        }
    }

    static class LinkedList5 {
        Node head;
        Node tail;
        int size;

        public LinkedList5() {
            head = null;
            tail = null;
            size = 0;
        }
        public void pushFront(int value){
            size++;
            Node newNode = new Node(value);
            if(head == null){
                head = newNode;
                tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public void pushBack(int value){
            size++;
            Node newNode = new Node(value);
            if(tail == null){
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public int getSize(){
            return size;
        }
        public void printList(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Detect the Floyd's Cycle
        public boolean detectCycle(){
            Node turtle = head;
            Node hare = head;

            while(hare != null && hare.next != null){
                turtle = turtle.next;
                hare = hare.next.next;
                if(hare == turtle){
                    return true;
                }
            }
            return false;
        }
        // Remove the Floyd's Cycle
        public void removeCycle() {
            if (!this.detectCycle()) {
                return;
            }
        
            Node turtle = head;
            Node hare = head;
        
            // Find the meeting point (hare and turtle meet inside the cycle)
            while (hare != null && hare.next != null) {
                turtle = turtle.next;
                hare = hare.next.next;
                if (hare == turtle) {
                    break;
                }
            }
        
            // Check if there is no cycle (hare and turtle did not meet)
            if (hare == null || hare.next == null) {
                return;
            }
        
            // Reset one of the pointers to the head
            turtle = head;
        
            // Move both pointers one step at a time until they meet (at the start of the cycle)
            while (turtle.next != hare.next) {
                turtle = turtle.next;
                hare = hare.next;
            }
        
            // Break the cycle by setting the next of the meeting point to null
            hare.next = null;
        }
        
    }

    public static void main(String[] args) {
        LinkedList5 list = new LinkedList5();
        for(int i = 1; i <= 10; i++){
            list.pushBack(i);
        }
        list.printList();
        System.out.println( list.detectCycle() );
    }
}
