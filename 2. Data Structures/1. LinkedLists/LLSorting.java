public class LLSorting {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList6 {
        Node head;
        Node tail;
        int size;

        public LinkedList6() {
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
        private Node getMid(Node head) {
            Node turtle = head;
            Node hare = head.next;
            while (hare != null && hare.next != null) {
                hare = hare.next.next;
                turtle = turtle.next;
            }
            return turtle;
        }

        private Node merge(Node left, Node right) {
            Node sortedLL = new Node(-1);
            Node temp = sortedLL;
        
            while (left != null && right != null) {
                if (left.data < right.data) {
                    temp.next = new Node(left.data);
                    left = left.next;
                } else {
                    temp.next = new Node(right.data);
                    right = right.next;
                }
                temp = temp.next;
            }
        
            while (left != null) {
                temp.next = new Node(left.data);
                temp = temp.next;
                left = left.next;
            }
        
            while (right != null) {
                temp.next = new Node(right.data);
                temp = temp.next;
                right = right.next;
            }
        
            return sortedLL.next;
        }
        
        private Node mergSortHelper(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node mid = getMid(head);
        
            Node rightHead = mid.next;
            mid.next = null;
        
            Node newLeftHead = mergSortHelper(head);
            Node newRightHead = mergSortHelper(rightHead);
        
            return merge(newLeftHead, newRightHead);
        }
        

        public void mergeSort(){
            this.head = this.mergSortHelper(this.head);
        }
    }

    public static void main(String[] args) {
        LinkedList6 list = new LinkedList6();
        list.pushBack(7);
        list.pushBack(2);
        list.pushBack(9);
        list.pushBack(1);
        list.pushBack(5);
        list.pushBack(3);
        list.pushBack(8);
        list.pushBack(6);
        list.pushBack(4);
        list.pushBack(0);

        list.mergeSort();
        list.printList();
    }
}