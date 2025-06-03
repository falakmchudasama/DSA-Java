import java.util.Stack;

public class SValidParenthesis {
    public static boolean validParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);

            if((current == '(') || (current == '[') || (current == '{')){
                stack.push(current);
            }
            else if((current == ')' && stack.peek() == '(') || (current == ']' && stack.peek() == '[') || (current == '}' && stack.peek() == '{')){
                stack.pop();
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        String string1 = "([]){}";
        String string2 = "(([)])";

        boolean result1 = validParenthesis(string1);
        boolean result2 = validParenthesis(string2);

        System.out.println(result1 + " " + result2);
    }
}
