import java.util.ArrayList;
import java.util.Arrays;

public class GBellmanFord {
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

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n1, int n2) {
            this.node = n1;
            this.dist = n2;
        }

        @Override
        public int compareTo(Pair other) {
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

        public void bellmanFord(int src) {
            int[] distances = new int[V];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[src] = 0;

            for (int iteration = 0; iteration < V - 1; iteration++) {
                for (int u = 0; u < V; u++) {
                    if (distances[u] != Integer.MAX_VALUE) {
                        int dist = distances[u];
                        for (Edge edge : graph.get(u)) {
                            int v = edge.dest;
                            int wt = edge.wt;
                            distances[v] = Math.min(distances[v], dist + wt);
                        }
                    }
                }
            }

            for (int u = 0; u < V; u++) {
                if (distances[u] != Integer.MAX_VALUE) {
                    int dist = distances[u];
                    for (Edge edge : graph.get(u)) {
                        int v = edge.dest;
                        int wt = edge.wt;
                        if (dist + wt < distances[v]) {
                            System.out.println("Graph contains a negative cycle");
                            break;
                        }
                    }
                }
            }

            for (int distance : distances) {
                System.out.print(distance + " ");
            }
            System.out.println();
        }
    }

    public static void bellmanFordEdgeList(int n, int src, ArrayList<int[]> edgeList) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        for (int iteration = 0; iteration < n - 1; iteration++) {
            for (int[] edge : edgeList) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (distances[u] == Integer.MAX_VALUE) {
                    continue;
                }
                distances[v] = Math.min(distances[v], distances[u] + wt);
            }
        }

        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (distances[u] == Integer.MAX_VALUE) {
                continue;
            }
            if (distances[v] > distances[u] + wt) {
                System.out.println("Graph has a negative cycle");
                break;
            }
        }

        for (int distance : distances) {
            System.out.print(distance + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph1 = new Graph(6);

        graph1.push(0, 1, 2);
        graph1.push(0, 2, 4);

        graph1.push(1, 2, 1);
        graph1.push(1, 3, 7);

        graph1.push(2, 4, 3);

        graph1.push(3, 5, 1);

        graph1.push(4, 3, 2);
        graph1.push(4, 5, 5);

        graph1.bellmanFord(0); // 0 2 3 8 6 9

        // graph2 as an edgelist
        ArrayList<int[]> graph2 = new ArrayList<>();

        graph2.add(new int[] { 0, 1, 2 });
        graph2.add(new int[] { 0, 2, 4 });
        graph2.add(new int[] { 1, 2, 1 });
        graph2.add(new int[] { 1, 3, 7 });
        graph2.add(new int[] { 2, 4, 3 });
        graph2.add(new int[] { 3, 5, 1 });
        graph2.add(new int[] { 4, 3, 2 });
        graph2.add(new int[] { 4, 5, 5 });

        // a negative cycle: 5 -> 3 -> 4 -> 5
        graph2.add(new int[] { 5, 3, -6 });
        graph2.add(new int[] { 3, 4, -1 });
        graph2.add(new int[] { 4, 5, 2 });

        bellmanFordEdgeList(6, 0, graph2); // 0 2 3 -16 -17 -15
    }
}
