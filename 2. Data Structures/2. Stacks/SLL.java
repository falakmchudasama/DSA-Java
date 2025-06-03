public class SLL {

    static class Node {
        int data;
        Node next;
    
        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }
    
    static class Stack2 {
        Node head;
        Node tail;
    
        public Stack2() {
            head = null;
            tail = null;
        }
    
        public void push(int val){
            Node newNode = new Node(val);
            if(head == null){
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
    
        public void pop(){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            this.tail = temp;
        }
    
        public int peek(){
            return tail.data;
        }
    
        public boolean isEmpty(){
            return head == null;
        }
    
        public void printStack(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack2 stck = new Stack2();
        for(int i = 1; i <= 10; i++){
            stck.push(i);
        }
        stck.pop();
        stck.printStack();
        int peek = stck.peek();
        System.out.println(peek);
    }
}
