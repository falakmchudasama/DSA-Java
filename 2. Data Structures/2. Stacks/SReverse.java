import java.util.ArrayList;

public class SReverse {

    static class Stack1 {
        private ArrayList<Integer> stack = new ArrayList<>();
    
        public void push(int val){
            stack.add(val);
        }
    
        public void pop(){
            stack.remove(stack.size() - 1);
        }
    
        public int peek(){
            return stack.get(stack.size() - 1);
        }
    
        public boolean isEmpty(){
            return stack.size() == 0;
        }
    
        public void printStack(){
            for(int i = 0; i < stack.size(); i++){
                System.out.print(stack.get(i) + " ");
            }
            System.out.println();
        }
    }


    public static void pushBottom(Stack1 stck, int data){
        if(stck.isEmpty()){
            stck.push(data);
            return;
        }
        int top = stck.peek();
        stck.pop();
        pushBottom(stck, data);
        stck.push(top);
    }

    public static void reverse(Stack1 stck){
        if(stck.isEmpty()){
            return;
        }
        int top = stck.peek();
        stck.pop();
        reverse(stck);
        pushBottom(stck, top);
    }

    public static void main(String[] args) {
        Stack1 stck = new Stack1();
        for(int i = 1; i <= 4; i++){
            stck.push(i);
        }
        stck.printStack();
        reverse(stck);
        stck.printStack();
    }
}
