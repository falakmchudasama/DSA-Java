import java.util.Stack;

public class SDuplicateParenthesis {
    public static boolean duplicateParenthesis(String string){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < string.length(); i++){
            char current = string.charAt(i);
            if(current != ')' && current != ']' && current != '}'){
                stack.push(current);
            }
            else if(current == ')'){
                int count = 0;
                while(stack.peek() != '('){
                    stack.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }
                else{
                    stack.pop();
                }
            }
            else if(current == ']'){
                int count = 0;
                while(stack.peek() != '['){
                    stack.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }
                else{
                    stack.pop();
                }
            }
            else if(current == '}'){
                int count = 0;
                while(stack.peek() != '{'){
                    stack.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }
                else{
                    stack.pop();
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "((a+b) + c)";
        String str2 = "(((a+b) + c))";

        boolean result1 = duplicateParenthesis(str1);
        boolean result2 = duplicateParenthesis(str2);

        System.out.println(result1 + " " + result2);
    }
}
