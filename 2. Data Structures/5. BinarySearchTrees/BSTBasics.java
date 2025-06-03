public class BSTBasics {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    
        public TreeNode(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    
    class BST1 {
        public static void inOrder(TreeNode root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    
        public static TreeNode buildBST(TreeNode root, int val){
            if(root == null){
                return new TreeNode(val);
            }
            if(root.data > val){
                root.left = buildBST(root.left, val);
            }
            else{
                root.right = buildBST(root.right, val);
            }
            return root;
        }
        public static boolean search(TreeNode root, int key) {
            if(root == null){
                return false;
            }
            if(root.data == key){
                return true;
            }
            if(root.data > key){
                return search(root.left, key);
            }
            else{
                return search(root.right, key);
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {5,7,9,6,3,2,1,4,8};
        TreeNode root = new TreeNode( nodes[0] );
        for(int i = 1; i < nodes.length; i++){
            root = BST1.buildBST(root, nodes[i]);
        }
        BST1.inOrder(root);
        System.out.println();
        
        int key = 4;
        System.out.println(key + " is in the tree :- " + BST1.search(root, key) );
    }
}
