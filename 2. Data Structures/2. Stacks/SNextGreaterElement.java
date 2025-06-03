import java.util.Stack;
public class SNextGreaterElement {
    public static void findNextGreater(int Array[], int result[]){
        Stack<Integer> stack = new Stack<>();
        for(int i = Array.length - 1; i >= 0; i--){
            int current = Array[i];
            while(!stack.empty() && Array[stack.peek()] <= current){
                stack.pop();
            }

            if(stack.empty()){
                result[i] = -1;
            }
            else{
                result[i] = Array[stack.peek()];
            }
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        int Array[] = {6,8,0,1,3};
        int nextGreater[] = new int[Array.length];

        findNextGreater(Array, nextGreater);
        for(int i = 0; i < Array.length; i++){
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
