public class GenValidParenthesis {
    public static void genParanthesis(int n1, int n2, String str){
        if(n1 == 0 && n2 == 0){
            System.out.println(str);
            return;
        }
        if(n1 > 0){
            genParanthesis(n1-1, n2 , str + '(');
        }
        if(n2 > n1){
            genParanthesis(n1, n2-1 , str + ')');
        }
    }
    public static void main(String[] args) {
        int n = 3;
        genParanthesis(n, n, "");
    }
}
