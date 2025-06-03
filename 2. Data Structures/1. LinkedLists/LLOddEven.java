public class LLOddEven {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList11 {
        Node head;
        Node tail;
        int size;
    
        public LinkedList11() {
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

        public void seperateOddEven(){
            if(head == null){
                return;
            }
            Node dummy = head;
            while(dummy.next != null){
                Node temp = dummy.next;
                if(dummy.next.data % 2 == 1){
                    Node past = dummy;
                    Node present = dummy.next;
                    Node future = dummy.next.next;

                    while(present != null){
                        if(present.data % 2 == 0){
                            dummy.next = present;
                            present.next = temp;
                            past.next = future;
                            break;
                        }
                        if(future == null){
                            past = present;
                            present = future;
                        }
                        else{
                            past = present;
                            present = future;
                            future = future.next;
                        }
                    }
                }
                dummy = dummy.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList11 list1 = new LinkedList11();
        LinkedList11 list2 = new LinkedList11();

        list1.pushBack(8);
        list1.pushBack(12);
        list1.pushBack(10);
        list1.pushBack(5);
        list1.pushBack(4);
        list1.pushBack(6);
        list1.pushBack(1);
        list1.pushBack(16);

        list2.pushBack(1);
        list2.pushBack(3);
        list2.pushBack(5);
        list2.pushBack(7);

        list1.printList();
        list1.seperateOddEven();
        list1.printList();
        System.out.println();

        list2.printList();
        list2.seperateOddEven();
        list2.printList();
    }
}
