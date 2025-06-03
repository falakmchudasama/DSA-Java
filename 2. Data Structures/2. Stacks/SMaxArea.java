import java.util.Stack;

public class SMaxArea {
    public static int maxArea(int array[]) {
        int max = 0;
        int nsl[] = new int[array.length];
        int nsr[] = new int[array.length];

        // Next Smaller to Left
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i]) {
                stack.pop();
            }
            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Next Smaller to Right
        stack.clear();
        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i]) {
                stack.pop();
            }
            nsr[i] = stack.isEmpty() ? array.length : stack.peek();
            stack.push(i);
        }

        // Calculate maximum area
        for (int i = 0; i < array.length; i++) {
            int height = array[i];
            int width = nsr[i] - nsl[i] - 1;
            int currentArea = height * width;
            max = Math.max(currentArea, max);
        }

        return max;
    }
    public static void main(String[] args) {
        int towers[] = {2, 1, 5, 6, 2, 3};
        int result = maxArea(towers);
        System.out.println(result);
    }
}