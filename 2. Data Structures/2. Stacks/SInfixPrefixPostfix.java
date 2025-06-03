// import java.util.*;

// public class SInfixPrefixPostfix {

//     // 1. Infix to Postfix
//     private static String infixToPostfix(String infix) {
//         StringBuilder result = new StringBuilder();
//         Stack<Character> stack = new Stack<>();

//         for (int i = 0; i < infix.length(); i++) {
//             char currChar = infix.charAt(i);

//             if (currChar == ' ') { // Ignore the whitespace
//                 continue;
//             }

//             if (currChar == '(') { // Push the opening parenthesis
//                 stack.push(currChar);
//             } else if (currChar == ')') { // Pop all the operators that are over the opening one
//                 while (!stack.isEmpty() && stack.peek() != '(') {
//                     result.append(stack.pop());
//                 }
//                 stack.pop(); // Pop the opening
//             } else if (isOperator(currChar)) { // If the currChar is operator...
//                 while (!stack.isEmpty() && precedence(currChar) <= precedence(stack.peek())) { // Pop all the operator
//                                                                                                // with higher or similar
//                                                                                                // precedence
//                     result.append(stack.pop());
//                 }
//                 stack.push(currChar);
//             } else {
//                 result.append(currChar);
//             }
//         }

//         while (!stack.isEmpty()) {
//             result.append(stack.pop());
//         }

//         return result.toString();
//     }

//     // 2. Infix to Prefix
//     private static String infixToPrefix(String infix) {
//         Stack<Character> stack = new Stack<>();
//         String reversedInfix = new StringBuilder(infix).reverse().toString();
//         StringBuilder result = new StringBuilder();

//         for (int i = 0; i < reversedInfix.length(); i++) {
//             char currChar = reversedInfix.charAt(i);

//             if (currChar == ' ') { // Ignore the white spaces
//                 continue;
//             } else if (currChar == ')') { // Push the closing (opening) parenthesis
//                 stack.push(currChar);
//             } else if (currChar == '(') { // Pop all the operators that are over the closing (opening) one
//                 while (!stack.isEmpty() && stack.peek() != ')') {
//                     result.append(stack.pop());
//                 }
//                 stack.pop();
//             } else if (isOperator(currChar)) {
//                 while (!stack.isEmpty() && precedence(stack.peek()) > precedence(currChar)) {
//                     result.append(stack.pop());
//                 }
//                 stack.push(currChar);
//             } else {
//                 result.append(currChar);
//             }
//         }

//         while (!stack.isEmpty()) {
//             result.append(stack.pop());
//         }

//         return result.reverse().toString();
//     }

//     // Infix Evaluation
//     private static int infixEval(String infix, int[] values) {
//         Stack<Character> operatorStack = new Stack<>();
//         Stack<Integer> operandStack = new Stack<>();

//         for (int i = 0; i < infix.length(); i++) {
//             char currChar = infix.charAt(i);

//             if (currChar == ' ') {
//                 continue;
//             } else if (isOperator(currChar)) {
//                 while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(currChar)) {
//                     int operand2 = operandStack.pop();
//                     int operand1 = operandStack.pop();
//                     char operator = operatorStack.pop();
//                     int calculation = evaluate(operand1, operand2, operator);
//                     operandStack.push(calculation);
//                 }
//                 operatorStack.push(currChar);
//             } else if (currChar == '(') {
//                 operatorStack.push(currChar);
//             } else if (currChar == ')') {
//                 while (operatorStack.peek() != '(') {
//                     int operand2 = operandStack.pop();
//                     int operand1 = operandStack.pop();
//                     char operator = operatorStack.pop();
//                     int calculation = evaluate(operand1, operand2, operator);
//                     operandStack.push(calculation);
//                 }
//                 operatorStack.pop();
//             } else {
//                 int idx = currChar - 'A';
//                 if (idx >= values.length) {
//                     System.out.println("ERROR : No values for " + currChar + " was assigned");
//                     return -1;
//                 }
//                 operandStack.push(values[idx]);
//             }
//         }

//         while (!operatorStack.isEmpty()) {
//             int operand2 = operandStack.pop();
//             int operand1 = operandStack.pop();
//             char operator = operatorStack.pop();
//             int calculation = evaluate(operand1, operand2, operator);
//             operandStack.push(calculation);
//         }

//         return operandStack.pop();
//     }

//     // Prefix Evaluation
//     private static int prefixEval(String prefix, int[] values) {
//         Stack<Integer> stack = new Stack<>();

//         for (int i = prefix.length() - 1; i >= 0; i--) {
//             char currChar = prefix.charAt(i);

//             if (currChar == ' ') {
//                 continue;
//             } else if (!isOperator(currChar)) {
//                 int idx = currChar - 'A';
//                 if (idx >= values.length) {
//                     System.out.println("ERROR : No values for " + currChar + " was assigned");
//                     return -1;
//                 }
//                 stack.push(values[idx]);
//             } else {
//                 int calculation = evaluate(stack.pop(), stack.pop(), currChar);
//                 stack.push(calculation);
//             }
//         }

//         return stack.pop();
//     }

//     // Postfix Evaluation
//     private static int postfixEval(String postfix, int[] values) {
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i < postfix.length(); i++) {
//             char currChar = postfix.charAt(i);

//             if (currChar == ' ') {
//                 continue;
//             } else if (!isOperator(currChar)) {
//                 int idx = currChar - 'A';
//                 if (idx >= values.length) {
//                     System.out.println("ERROR : No values for " + currChar + " was assigned");
//                     return -1;
//                 }
//                 stack.push(values[idx]);
//             } else {
//                 int operand2 = stack.pop();
//                 int operand1 = stack.pop();
//                 int calculation = evaluate(operand1, operand2, currChar);
//                 stack.push(calculation);
//             }
//         }

//         return stack.pop();
//     }

//     // Helper methods
//     private static boolean isOperator(char ch) {
//         return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^';
//     }

//     private static int precedence(char operator) {
//         switch (operator) {
//             case '+':
//             case '-':
//                 return 1;
//             case '*':
//             case '/':
//             case '%':
//                 return 2;
//             case '^':
//                 return 3;
//             default:
//                 return -1;
//         }
//     }

//     private static int evaluate(int operand1, int operand2, char operator) {
//         switch (operator) {
//             case '+':
//                 return operand1 + operand2;
//             case '-':
//                 return operand1 - operand2;
//             case '*':
//                 return operand1 * operand2;
//             case '/':
//                 return operand1 / operand2;
//             case '^':
//                 return (int) Math.pow(operand1, operand2);
//             default:
//                 throw new IllegalArgumentException("Invalid operator: " + operator);
//         }
//     }

//     public static void main(String[] args) {
//         String infixString1 = "(A+B*C/D-E+F/G/(H+I))";

//         System.out.println();
//         System.out.println("--CONVERSIONS--");
//         System.out.println("Infix: " + infixString1);
//         System.out.println("Postfix: " + infixToPostfix(infixString1));
//         System.out.println("Prefix: " + infixToPrefix(infixString1));

//         // String infixString2 = infixString1;
//         // String prefixString2 = infixToPrefix(infixString1);
//         // String postfixString2 = infixToPostfix(infixString1);
//         // int[] values = new int[] { 5, 7, 9, 3, 4, 10, 8, 3, 4, 8 };

//         // System.out.println();
//         // System.out.println("--EVALUATIONS--");
//         // System.out.println("Infix: " + infixEval(infixString2, values));
//         // System.out.println("Prefix: " + prefixEval(prefixString2, values));
//         // System.out.println("Postfix: " + postfixEval(postfixString2, values));
//     }
// }
