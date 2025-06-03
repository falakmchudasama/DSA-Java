import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GCycleDetection3 {
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

        public boolean kahn() {
            boolean[] visited = new boolean[V];
            int[] indegrees = new int[V];
            Queue<Integer> q = new LinkedList<>();
            int processedNodes = 0;

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
                processedNodes++;
                for (Edge e : graph.get(node)) {
                    indegrees[e.dest]--;
                    if (indegrees[e.dest] == 0) {
                        q.add(e.dest);
                    }
                }
            }
            return processedNodes != V;
        }
    }
    public static void main(String[] args) {
        Graph graph1 = new Graph(5);
        Graph graph2 = new Graph(5);

        graph1.push(0, 1, 0);
        graph1.push(0, 2, 0);
        graph1.push(1, 3, 0);
        graph1.push(1, 4, 0);
        graph1.push(3, 4, 0);

        graph2.push(0, 1, 0);
        graph2.push(0, 2, 0);
        graph2.push(1, 3, 0);
        graph2.push(3, 4, 0);
        graph2.push(4, 1, 0);

        System.out.println("Graph1 has a cycle : " + graph1.kahn());
        System.out.println("Graph2 has a cycle : " + graph2.kahn());
    }
}
