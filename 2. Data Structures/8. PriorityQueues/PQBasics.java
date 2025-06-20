import java.util.Comparator;
import java.util.PriorityQueue;

public class PQBasics {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( Comparator.reverseOrder() );

        pq.add(5);
        pq.add(7);
        pq.add(4);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(6);

        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
