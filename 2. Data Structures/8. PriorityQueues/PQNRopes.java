import java.util.PriorityQueue;

public class PQNRopes {
    public static int nRopes(int[] ropes){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < ropes.length; i++){
            pq.add(ropes[i]);
        }
        int a, b, c = 0;
        while (pq.size() > 1) {
            a = pq.remove();
            b = pq.remove();
            c += a + b;
            pq.add(a+b);
        }
        return c;
    }
    public static void main(String[] args) {
        int[] ropes = {2,3,3,4,6};
        int cost = nRopes(ropes);
        System.out.println(cost);
    }
}
