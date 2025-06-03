import java.util.ArrayList;

public class GFloydMarshall {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int n1, int n2, int n3) {
            this.src = n1;
            this.dest = n2;
            this.wt = n3; 
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n1, int n2){
            this.node = n1;
            this.dist = n2;
        }

        @Override
        public int compareTo(Pair other){
            return this.dist - other.dist;
        }
    }

    static class Graph {
        private int V;
        private ArrayList<ArrayList<Edge>> graph;

        public Graph(int n) {
            this.V = n;
            graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void push(int src, int dest, int wt) {
            graph.get(src).add(new Edge(src, dest, wt));
        }

        public void bellmanFord(int src){
            int[] distances = new int[V];
            for (int i = 0; i < V; i++) {
                if (i == src) {
                    distances[i] = 0;
                } else {
                    distances[i] = Integer.MAX_VALUE;
                }
            }

            for (int iteration = 0; iteration < V - 1; iteration++) {
                
            }

            for (int distance : distances) {
                System.out.print(distance + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.push(0, 1, 2);
        graph.push(0, 2, 4);

        graph.push(1, 2, 1);
        graph.push(1, 3, 7);

        graph.push(2, 4, 3);

        graph.push(3, 5, 1);

        graph.push(4, 3, 2);
        graph.push(4, 5, 5);

        graph.bellmanFord(0); // 0 2 3 8 6 9 
    }
}
