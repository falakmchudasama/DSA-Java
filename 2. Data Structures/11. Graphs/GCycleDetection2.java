import java.util.ArrayList;

public class GCycleDetection2 {
    // For undirected graphs
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

        public boolean helper(int parent, int curr, boolean visited[]){
            visited[curr] = true;

            for(Edge edge : graph.get(curr)){
                if(visited[edge.dest] && parent != edge.dest){
                    return true;
                }
                else if(!visited[edge.dest]){
                    if(helper(curr, edge.dest, visited)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean hasCycle(){
            boolean visited[] = new boolean[V];
            for(int i = 0; i < V; i++){
                if(!visited[i]){
                    if(helper(-1, i, visited)){
                        return true;
                    }
                }
            }
            return false;
        }

    }
    public static void main(String[] args) {
        GCycleDetection2.Graph graph1 = new GCycleDetection2.Graph(4);

        graph1.push(0, 1, 0);
        graph1.push(0, 2, 0);

        graph1.push(1, 0, 0);
        graph1.push(1, 3, 0);

        graph1.push(2, 3, 0);

        graph1.push(3, 1, 0);
        graph1.push(3, 2, 0);



        GCycleDetection2.Graph graph2 = new GCycleDetection2.Graph(4);

        graph2.push(0, 1, 0);

        graph2.push(1, 0, 0);
        graph2.push(1, 2, 0);

        graph2.push(2, 1, 0);
        graph2.push(2, 3, 0);
        
        graph2.push(3, 2, 0);


        System.out.println("Graph 1 has cycle: " + graph1.hasCycle());
        System.out.println("Graph 2 has cycle: " + graph2.hasCycle());
    }
}
