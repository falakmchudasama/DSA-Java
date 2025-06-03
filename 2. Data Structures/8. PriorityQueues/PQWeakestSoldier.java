import java.util.PriorityQueue;

public class PQWeakestSoldier {
    static class Row implements Comparable<Row>{
        int idx;
        int soldier;
        public Row(int idx, int soldier){
            this.idx = idx;
            this.soldier = soldier;
        }
        @Override
        public int compareTo(Row r2){
            if(this.soldier == r2.soldier){
                return this.idx - r2.idx;
            }
            else{
                return this.soldier - r2.soldier;
            }
        }
    }
    public static int weakestRow(int[][] camp, int m, int n, int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++){
            int temp = 0;
            for(int j = 0; j < n; j++){
                temp += camp[i][j];
            }
            Row newRow = new Row(i, temp);
            pq.add(newRow);
        }
        int result = 0;
        for(int i = 0; i < k; i++){
            result = pq.remove().idx;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] camp = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,1,0,0}};
        int m = 4;
        int n = 4;
        int k = 2;

        int weakestRow = weakestRow(camp, m, n, k);
        System.out.println(weakestRow);
    }
}
