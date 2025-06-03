public class TBasics {

    static class TNode {
        TNode[] children = new TNode[26];
        boolean eow = false;
        TNode() {
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }
    // creation of the root node
    public static TNode root = new TNode();

    public static void push(String word){
        TNode temp = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null){
                temp.children[idx] = new TNode();
            }
            temp = temp.children[idx];
        }
        temp.eow = true;
    }

    public static boolean search(String word) {
        TNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.children[idx] == null) {
                return false;
            }
            temp = temp.children[idx];
        }
        return temp.eow; // Check if the last node represents the end of a word
    }
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        for(int i = 0; i < words.length; i++){
            push(words[i]);
        }
        boolean result1 = search("the");
        boolean result2 = search("the");

        System.out.println(result1);
        System.out.println(result2);
    }
}
