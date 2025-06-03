import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GKahn {
    // For directed graphs
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int n1, int n2, int n3){
            this.src = n1;
            this.dest = n2;
            this.wt = n3;
        }
    }

    static class Graph {
        private int V;
        private ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        public Graph(int n){
            this.V = n;
            for(int i = 0; i < V; i++){
                graph.add(new ArrayList<>());
            }
        }

        public void push(int src, int dest, int wt){
            graph.get(src).add(new Edge(src, dest, wt));
        }

        public void kahn() {
            boolean[] visited = new boolean[V];
            int[] indegrees = new int[V];
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < graph.size(); i++) {
                for (Edge e : graph.get(i)) {
                    indegrees[e.dest]++;
                }
            }
            for (int i = 0; i < graph.size(); i++) {
                if (indegrees[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                visited[node] = true;
                System.out.print(node + " -> ");
                for (Edge e : graph.get(node)) {
                    indegrees[e.dest]--;
                    if (indegrees[e.dest] == 0) {
                        q.add(e.dest);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.push(0, 1, 0);
        graph.push(0, 2, 0);
        graph.push(1, 3, 0);
        graph.push(1, 4, 0);
        graph.push(3, 4, 0);

        graph.kahn();
    }
}
