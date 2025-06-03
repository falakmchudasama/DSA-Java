public class BSTBalanced {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    
        public TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    
    class BST6 {
        public static void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    
        public static TreeNode buildBST(int[] nodes, int start, int end) {
            if(start > end){
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode Node = new TreeNode( nodes[mid] );
            Node.left = buildBST(nodes, start, mid-1);
            Node.right = buildBST(nodes, mid+1, end);
    
            return Node;
        }
    
        public static void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {3,5,6,7,10,11};
        TreeNode root = BST6.buildBST(nodes, 0, nodes.length-1);
        BST6.preOrder(root);
        System.out.println();
        BST6.inOrder(root);
    }
}
