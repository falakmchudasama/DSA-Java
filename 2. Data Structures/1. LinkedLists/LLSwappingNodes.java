public class LLSwappingNodes {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList9 {
        Node head;
        Node tail;
        int size;
    
        public LinkedList9() {
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

        public void swap(int x, int y){
            if(x == y || x > size || y > size){
                return;
            }

            // Step 1 : Traverse to x
            Node currX = head;
            Node prevX = null;
            for(int i = 1; i < x; i++){
                prevX = currX;
                currX = currX.next;
            }

            // Step 2 : Traverse to y
            Node currY = head;
            Node prevY = null;
            for(int i = 1; i < y; i++){
                prevY = currY;
                currY = currY.next;
            }

            // Step 3 : Connect prevs to currs
            if(prevX != null){
                prevX.next = currY;
            }
            else{
                head = currY;
            }

            if(prevY != null){
                prevY.next = currX;
            }
            else{
                head = currX;
            }

            // Step 4 : Connect the currs
            Node temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;
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
        LinkedList9 list = new LinkedList9();
        for (int i = 1; i <= 8; i++) {
            list.pushBack(i);
        }
        list.printList();
        int x = 2;
        int y = 5;
        list.swap(x,y);
        list.printList();
    }
}
