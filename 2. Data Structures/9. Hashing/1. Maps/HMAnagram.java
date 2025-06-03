import java.util.HashMap;

public class HMAnagram {
    public static boolean areAnagrams(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int i = 0; i < s2.length(); i++){
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0)+1);
        }

        for (Character key : map.keySet()) {
            if(map.get(key) % 2 != 0){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        boolean result = areAnagrams(str1, str2);
        System.out.println(result);
    }
}
