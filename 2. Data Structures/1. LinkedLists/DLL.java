public class DLL {

    static class Node2 {
        int data;
        Node2 next;
        Node2 prev;

        Node2(int val){
            this.data = val;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoubleLinkedList {
        Node2 head;
        Node2 tail;
        int size;

        public DoubleLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void pushFront(int val){
            size++;
            Node2 newNode = new Node2(val);
            if(head == null){
                head = newNode;
                tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        public void pushBack(int val){
            size++;
            Node2 newNode = new Node2(val);
            if(head == null){
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        public int getSize(){
            return this.size;
        }
        public void popFront(){
            head = head.next;
            head.prev = null;
        }
        public void popBack(){
            tail = tail.prev;
            tail.next = null;
        }
        public void reverse(){
            Node2 current = head;
            Node2 previous = null;
            Node2 next;

            while(current != null){
                next = current.next;
                current.next = previous;
                current.prev = next;

                previous = current;
                current = next;
            }
            head = previous;
        }
        public void printList(){
            Node2 temp = head;
            System.out.print("null <-> ");
            while(temp != null){
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        for(int i = 1 ; i <= 5 ;i++){
            list.pushBack(i);
        }
        list.printList();
        list.reverse();
        list.printList();
    }
}
