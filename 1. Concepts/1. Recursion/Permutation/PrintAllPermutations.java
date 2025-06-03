public class PrintAllPermutations {
    public static void permutation(String str, String str2){
        if(str.length() == 0){
            System.out.println(str2);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            permutation(newStr, str2 + c);
        }
    }
    public static void main(String[] args) {
        permutation("ABC", "");
    }
}
