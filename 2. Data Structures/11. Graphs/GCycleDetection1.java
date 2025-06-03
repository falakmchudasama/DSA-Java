import java.util.ArrayList;

public class GCycleDetection1 {
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

        public boolean helper(int curr, boolean visited[], boolean stack[]){
            visited[curr] = true;
            stack[curr] = true;

            for(Edge edge : graph.get(curr)){
                if(stack[edge.dest] == true){
                    return true;
                }
                else if(!visited[edge.dest]){
                    return helper(edge.dest, visited, stack);
                }
            }

            stack[curr] = false;
            return false;
        }

        public boolean hasCycle(){
            boolean visited[] = new boolean[V];
            boolean stack[] = new boolean[V];
            for(int i = 0; i < V; i++){
                if(!visited[i]){
                    if(helper(i, visited, stack)){
                        return true;
                    }
                }
            }
            return false;
        }

    }
    public static void main(String[] args) {
        Graph graph1 = new Graph(4);

        graph1.push(0, 1, 0);
        graph1.push(0, 2, 0);
        graph1.push(1, 3, 0);
        graph1.push(2, 3, 0);

        Graph graph2 = new Graph(4);

        graph2.push(0, 2, 0);
        graph2.push(2, 3, 0);
        graph2.push(3, 0, 0);
        graph2.push(1, 0, 0);

        System.out.println(graph1.hasCycle());
        System.out.println(graph2.hasCycle());
    }
}
