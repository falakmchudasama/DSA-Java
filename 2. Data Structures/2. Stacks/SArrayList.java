import java.util.ArrayList;

class Stack1 {
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

public class SArrayList {
    public static void main(String[] args) {
        Stack1 stck = new Stack1();
        for(int i = 1; i <= 10; i++){
            stck.push(i);
        }
        stck.pop();
        stck.printStack();
        int peek = stck.peek();
        System.out.println(peek);
    }
}
