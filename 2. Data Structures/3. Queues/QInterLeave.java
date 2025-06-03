import java.util.Queue;
import java.util.LinkedList;

public class QInterLeave {
    public static Queue<Integer> interLeave(Queue<Integer> queue) {
        int half = queue.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < half; i++) {
            firstHalf.add(queue.remove());
        }

        // Interleave the elements and add them back to the original queue
        while (!firstHalf.isEmpty()) {
            queue.add(firstHalf.remove());
            queue.add(queue.remove());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(i);
        }
        Queue<Integer> result = interLeave(queue);
        while (!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
        System.out.println();
    }
}
