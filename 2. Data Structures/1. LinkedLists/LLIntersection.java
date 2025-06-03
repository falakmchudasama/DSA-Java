public class LLIntersection {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList10 {
        Node head;
        Node tail;
        int size;
    
        public LinkedList10() {
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

        public void printIntersection(LinkedList10 head2){
            Node temp1 = this.head;
            Node temp2 = head2.head;
            int size1 = size;
            int size2 = head2.getSize();
            size1 = size1-size2;
            int count = size1;

            while(count != 0){
                temp1 = temp1.next;
                count--;
            }

            while(temp1 != null){
                if(temp1 == null || temp2 == null){
                    return;
                }
                else if(temp1.data == temp2.data){
                    break;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            while(temp1 != null && temp2 != null){
                if(temp1 == null || temp2 == null){
                    System.out.println("null");
                    return;
                }
                else if(temp1.data == temp2.data){
                    System.out.print(temp1.data + " -> ");
                }
                else if(temp1.data != temp2.data){
                    System.out.println("end");
                    return;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            System.out.println("null");
            return;
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
        LinkedList10 list1 = new LinkedList10();
        LinkedList10 list2 = new LinkedList10();
        for(int i = 1; i <= 7; i++){
            if(i == 4 || i == 5){
                continue;
            }
            list1.pushBack(i);
        }
        
        for(int i = 4; i <= 7; i++){
            list2.pushBack(i);
        }
        list1.printIntersection(list2);
        list1.printList();
        list2.printList();
    }
}
