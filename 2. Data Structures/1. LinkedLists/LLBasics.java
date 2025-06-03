public class LLBasics {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList1 {
        Node head;
        Node tail;
        int size;
    
        public LinkedList1() {
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
    
        void insert(int index, int value){
            Node newNode = new Node(value);
            if(index == 0){
                this.pushFront(value);
                return;
            }
            if(index == size){
                this.pushBack(value);
                return;
            }
            if(index > size){
                System.out.println("Error");
                return;
            }
            Node temp = head;
            int count = 1;
            while(count < index){
                temp = temp.next;
                count++;
            }
            Node nodetoInsert = temp.next;
            temp.next = newNode;
            newNode.next = nodetoInsert;
            size++;
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
    }

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.insert(4, 5);
        list.printList();
        int size = list.getSize();
        System.out.println(size);
    }
}
