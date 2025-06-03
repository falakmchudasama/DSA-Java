import java.util.Queue;
import java.util.LinkedList;

public class QFNRL {
    public static void firstNonRepeatingLetter(String str){
        Queue<Character> queue = new LinkedList<>();
        int freq[] = new int[26];

        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            freq[current - 'a']++;

            queue.add(current);
            char front = queue.peek();
            while(true){
                if(queue.isEmpty()){
                    System.out.print("-1" + " ");
                    break;
                }
                front = queue.peek();
                if( freq[front - 'a'] == 1 ){
                    System.out.print(front + " ");
                    break;
                }
                else{
                    queue.remove();
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String string = "aabccxb";
        firstNonRepeatingLetter(string);
    }
}
