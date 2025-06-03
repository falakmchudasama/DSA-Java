public class LLAdvanced {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList3 {
        Node head;
        Node tail;
        int size;
    
        public LinkedList3() {
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
        public void printList(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public int getSize(){
            return this.size;
        }
        public int search(int value){
            int count = 0;
            Node temp = head;
            while(temp.data != value && temp != null){
                temp = temp.next;
                count++;
            }
            if(temp == null){
                System.out.println("Element not found");
                count = -1;
            }
            return count;
        }
        public int searchRecursive(int val){
            Node temp = head;
            return searchHelper(temp, val);
        }
        int searchHelper(Node temp, int val){
            if(temp == null){
                return -1;
            }
            if(temp.data == val){
                return 0;
            }
            int index = searchHelper(temp.next, val);
            return index+1;
        }
        public void reverse(){
            Node prev = null;
            Node current = head;
            tail = head;
    
            while(current != null){
                Node nxt = current.next;
                current.next = prev;
    
                prev = current;
                current = nxt;
            }
            head = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList3 list = new LinkedList3 ();
        for(int i = 1; i < 5; i++){
            list.pushBack(i);
        }
        list.printList();
        list.reverse();
        list.printList();
    }
}
