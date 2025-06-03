public class NPaths {
    public static int calcPaths(int i, int j, int m, int n){
        if(i == m || j == n){
            return 0;
        }
        if(i == m-1 && j == n-1){
            System.out.println("(" + i + "," + j + ")");
            return 1;
        }
        
        System.out.print("(" + i + "," + j + ")");
        int goRight = calcPaths(i+1, j, m, n);
        int goDown = calcPaths(i, j+1, m, n);

        return goRight+goDown;
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int totalPaths = calcPaths(0, 0, m, n);
        System.out.println(totalPaths);
    }
}
