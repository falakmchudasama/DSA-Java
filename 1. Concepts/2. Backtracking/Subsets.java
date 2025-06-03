public class Subsets {
    public static void subset(String str, String result, int i){
        if(i == str.length()){
            if(result == ""){
                return;
            }
            else{
                System.out.println(result);
                return;
            }
        }
        // Yes
        subset(str, result+str.charAt(i), i+1);

        // No
        subset(str, result, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        subset(str, "", 0);
    }
}
