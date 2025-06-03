public class TowerOfHanoi {
    private static int step = 0;
    
    public static void TOI(int n, String A, String B, String C) {
        if(n <= 0){
            return;
        }
        if (n == 1) {
            step++;
            System.out.println(step + " step. Move disk from " + A + " to " + C);
            return;
        }
        TOI(n - 1, A, C, B);
        step++;
        System.out.println(step + " step. Move disk from " + A + " to " + B);
        TOI(n - 1, C, B, A);
    }

    public static void main(String[] args) {
        int n = 2;
        TOI(n, "A", "B", "C");
    }
}