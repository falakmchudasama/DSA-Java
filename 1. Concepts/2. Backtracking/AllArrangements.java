public class AllArrangements {
    public static void arrange(String str, String result){
        if(str.length() == 0){
            System.out.println(result);
        }

        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);

            arrange(newString, result+currentChar);
        }
    }
    public static void main(String[] args) {
        String string = "ab";
        arrange(string, "");
    }
}
