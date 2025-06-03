import java.util.ArrayDeque;
import java.util.Deque;

public class QSlidingWindowMax {
    public static void slidingWindows(int[] array, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i <= array.length-k; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < k+i && j < array.length; j++){
                if(max <= array[j]){
                    dq.addFirst(array[j]);
                    max = array[j];
                }
                else{
                    dq.addLast(array[j]);
                }
            }
            System.out.print(dq.getFirst() + " ");
            dq.clear();
        }
    }
    public static void main(String[] args) {
        int[] array = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        // 3 3 5 5 6 7 
        slidingWindows(array, k);
    }
}