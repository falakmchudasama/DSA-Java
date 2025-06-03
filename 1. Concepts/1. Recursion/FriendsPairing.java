public class FriendsPairing {
    public static int Friends(int n){
        if(n == 1 || n == 2){
            return n;
        } 
        int single = Friends(n-1);
        int pair = (n-1)*Friends(n-2);

        return single + pair;
    }
    public static void main(String[] args) {
        System.out.println(Friends(5));
    }
}