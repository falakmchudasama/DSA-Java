import java.util.ArrayList;
import java.util.Stack;

public class GTopologicalSort {
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

        public void helper(int curr, boolean visited[], Stack<Integer> stack){
            visited[curr] = true;

            for(Edge edge : graph.get(curr)){
                if(!visited[edge.dest]){
                    helper(edge.dest, visited, stack);
                }
            }

            stack.push(curr);
        }

        public void topoSort() {
            boolean visited[] = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < V; i++){
                if(!visited[i]){
                    helper(i, visited, stack);
                }
            }

            while(!stack.empty()){
                System.out.print(stack.pop() + " -> ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.push(0, 1, 0);
        graph.push(0, 2, 0);
        graph.push(1, 3, 0);
        graph.push(1, 4, 0);
        graph.push(2, 0, 0);
        graph.push(3, 4, 0);

        graph.topoSort();
    }
}
