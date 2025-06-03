import java.util.PriorityQueue;

public class PQSlidingWindowsMax {
    static class Pair implements Comparable<Pair> {
        int val;
        int index;
        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2){
            return Integer.compare(p2.val, this.val);
        }
    }
    public static void slidingWindows(int[] array, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Adding all the elements
        for(int i = 0; i < k; i++){
            pq.add( new Pair(array[i], i) );
        }

        for(int i = k; i < array.length; i++){
            System.out.print(pq.peek().val + " ");
            while(!pq.isEmpty() && pq.peek().index <= (i-k)){
                pq.remove();
            }
            pq.add( new Pair(array[i], i) );
        }
        System.out.println(pq.peek().val);
    }
    public static void main(String[] args) {
        int[] array = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        slidingWindows(array, k);
    }
}