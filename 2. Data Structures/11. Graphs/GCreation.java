import java.util.ArrayList;

public class GCreation {
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
    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")

        // Graph is bi-directional and weighted
        ArrayList<Edge> graph[] = new ArrayList[V];
        
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 2));

        for(int i = 0; i < graph.length; i++){
            System.out.print(i + " -> ");
            for(int j = 0; j < graph[i].size(); j++){
                System.out.print(graph[i].get(j).dest + " ");
            }
            System.out.println();
        }
    }
}