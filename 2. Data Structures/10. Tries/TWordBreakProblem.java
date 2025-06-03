public class TWordBreakProblem {

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
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        System.out.println(words);
        System.out.println(key);
    }
}
