public class DiceGame {
    public static void countPaths(int start, int end, String str){
        if(start == end){
            System.out.println(str);
            return;
        }
        if(start > end){
            return;
        }
        for(int i = 1; i <= 6; i++){
            str += i + " ";
            countPaths(start+i, end, str);
        }
    }
    public static void main(String[] args) {
        countPaths(0, 3, "");
    }
}
