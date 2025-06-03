public class BSTPrintRange {

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
    
    class BST3 {
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
        public static void printRange(TreeNode root, int min, int max){
            if(root == null){
                return;
            }
            printRange(root.left, min, max);
            if(root.data >= min && root.data <= max){
                System.out.print(root.data + " ");
            }
            printRange(root.right, min, max);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {5,7,9,6,3,2,1,4,8};
        TreeNode root = new TreeNode( nodes[0] );
        for(int i = 1; i < nodes.length; i++){
            root = BST3.buildBST(root, nodes[i]);
        }
        int min = 5;
        int max = 7;
        BST3.printRange(root, min, max);
    }
}
