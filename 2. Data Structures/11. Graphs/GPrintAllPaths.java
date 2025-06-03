import java.util.ArrayList;

public class GPrintAllPaths {
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

        private void helper(String str,ArrayList<ArrayList<Edge>> graph,int src, int dest, boolean[] visited){
            if(src == dest){
                System.out.println(str);
                return;
            }

            for(int i = 0; i < graph.get(src).size(); i++){
                Edge edge = graph.get(src).get(i);
                if(!visited[edge.dest]){
                    visited[edge.dest] = true;
                    helper(str + edge.dest + " ", graph, edge.dest, dest, visited);
                    visited[edge.dest] = false;
                }
            }
        }

        public void printPaths(int src, int dest) {
            boolean[] visited = new boolean[V];
            visited[src] = true;
            helper(src + " ",graph, src, dest, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.push(0, 1, 0);
        graph.push(0, 2, 0);

        graph.push(1, 0, 0);
        graph.push(1, 3, 0);

        graph.push(2, 0, 0);
        graph.push(2, 4, 0);

        graph.push(3, 1, 0);
        graph.push(3, 4, 0);
        graph.push(3, 5, 0);

        graph.push(4, 2, 0);
        graph.push(4, 3, 0);
        graph.push(4, 5, 0);

        graph.push(5, 3, 0);
        graph.push(5, 4, 0);
        graph.push(5, 6, 0);

        graph.push(6, 5, 0);

        graph.printPaths(0,5);
    }
}