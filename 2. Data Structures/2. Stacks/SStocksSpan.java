import java.util.Stack;

public class SStocksSpan {
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for(int i = 1; i < stocks.length; i++){
            int current = stocks[i];
            while(!stack.empty() && current > stocks[stack.peek()]){
                stack.pop();
            }
            if(stack.empty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];

        stockSpan(stocks, span);

        for(int i = 0; i < span.length; i++){
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }
}
