import java.util.ArrayList;
public class LLPalindrome {

    static class Node {
        int data;
        Node next;
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    static class LinkedList4 {
        Node head;
        Node tail;
        int size;

        public LinkedList4() {
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

        // Space complexity O(n)
        public boolean palindromeOrNot1(){
            int div = this.size / 2;
            boolean flag = true;
            
            ArrayList<Integer> array = new ArrayList<Integer>();

            Node temp = head;
            for (int i = 0; i < div; i++) {
                array.add(temp.data);
                temp = temp.next;
            }

            if(size % 2 != 0){
                temp = temp.next;
            }

            for(int i = div - 1; i >= 0; i--){
                if(array.get(i) != temp.data){
                    flag = false;
                    return flag;
                }
                temp = temp.next;
            }
            return flag;
        }

        public boolean palindromeOrNot2(){
            Node temp = head;
            LinkedList4 firstHalf = new LinkedList4();
            int div = this.size / 2;
            boolean flag = true;

            int count = div;
            while(count > 0){
                int current = temp.data;
                firstHalf.pushFront(current);
                temp = temp.next;
                count--;
            }
            if(this.size % 2 != 0){
                firstHalf.pushFront(temp.data);
            }
            Node temp2 = firstHalf.head;

            while(temp != null){
                if(temp.data != temp2.data){
                    flag = false;
                    return flag;
                }
                temp = temp.next;
                temp2 = temp2.next;
            }
            return flag;
        }
    }

    public static void main(String[] args) {
        LinkedList4 list = new LinkedList4();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(3);
        list.pushBack(2);
        list.pushBack(1);
        boolean yes = list.palindromeOrNot1();
        System.out.println(yes);
        yes = list.palindromeOrNot2();
        System.out.println(yes);
    }
}