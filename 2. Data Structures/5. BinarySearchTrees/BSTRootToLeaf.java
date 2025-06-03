public class BSTRootToLeaf {

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

    class BST4 {
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
        public static void printPath(TreeNode root, int val){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            if(root.data > val){
                printPath(root.left, val);
            }
            else{
                printPath(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {11,4,6,7,8,9,1,12,13,15,3,17,2};
        TreeNode root = new TreeNode( nodes[0] );
        for(int i = 1; i < nodes.length; i++){
            root = BST4.buildBST(root, nodes[i]);
        }
        BST4.printPath(root, 2);
    }
}
