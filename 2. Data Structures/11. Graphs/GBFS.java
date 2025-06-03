import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GBFS {
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

        public void printBFS(){
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[graph.size()];
            q.add(graph.get(0).get(0).src);

            while(!q.isEmpty()){
                int curr = q.remove();
                if(visited[curr] == false){
                    System.out.print(curr + " ");
                    visited[curr] = true;
                    for(int i = 0; i < graph.get(curr).size(); i++){
                        q.add(graph.get(curr).get(i).dest);
                    }
                }
            }
            System.out.println();
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

        graph.printBFS();
    }
}
