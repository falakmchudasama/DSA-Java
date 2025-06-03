public class LLModerate {

    static class Node {
        int data;
        Node next;
        
        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    static class LinkedList2 {
        Node head;
        Node tail;
        int size;

        public LinkedList2() {
            this.head = null;
            this.tail = null;
        }

        public void pushFront(int value) {
            size++;
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void pushBack(int value) {
            size++;
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public void remove(int index) {
            if (index == 0) {
                removeHead();
                return;
            }
            if (index >= size) {
                System.out.println("Error");
                return;
            }
            if (index == size - 1) {
                removeTail();
                return;
            }
            size--;
            int count = 1;
            Node temp = head;
            while (count < index) {
                temp = temp.next;
                count++;
            }
            Node insertThis = temp.next.next;
            temp.next = insertThis;
        }

        public void removeHead() {
            if (head == null) {
                return;
            }
            head = head.next;
            size--;
        }

        public void removeTail() {
            if (head == null || head == tail) {
                head = null;
                tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
        }

        public void removeNthFromEnd(int index) {
            int length = size;
            int fromStart = length - index - 1;
            remove(fromStart);
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public int getSize() {
            return this.size;
        }
    }
    
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();

        for (int i = 1; i <= 8; i++) {
            list.pushBack(i);
        }

        list.removeNthFromEnd(8);
        list.printList();
    }
}
