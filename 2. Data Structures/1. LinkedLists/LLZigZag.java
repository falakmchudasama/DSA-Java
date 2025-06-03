public class LLZigZag {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList7 {
        Node head;
        Node tail;
        int size;
    
        public LinkedList7() {
            this.head = null;
            this.tail = null;
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
            if(head == null){
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
    
        public int getSize(){
            return this.size;
        }
    
        public void printList(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    
        private Node getMid(Node head){
            Node turtle = head;
            Node hare = head.next;
    
            while(hare != null && hare.next != null){
                hare = hare.next.next;
                turtle = turtle.next;
            }
    
            return turtle;
        }
    
        public void makeZigZag(){
            Node temp = head;
    
            // Step 1 : get a mid
            Node mid = this.getMid(temp);
    
            // Step 2 : reverse right
            Node current = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;
    
            while(current != null){
                next = current.next;
                current.next = prev;
    
                prev = current;
                current = next;
            }
    
            Node left = head;
            Node right = prev;
            Node lNext, rNext;
    
            while(left != null && right != null){
                lNext = left.next;
                left.next = right;
                rNext = right.next;
                right.next = lNext;
    
                left = lNext;
                right = rNext;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList7 list = new LinkedList7();
        for(int i = 1; i <= 4; i++){
            list.pushBack(i);
        }
        list.printList();
        list.makeZigZag();
        list.printList();
    }
}
