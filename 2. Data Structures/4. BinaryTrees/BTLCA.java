import java.util.ArrayList;

public class BTLCA {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree8 {
        private int idx = -1;
    
        public TreeNode buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
    
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
    
            return newNode;
        }
    
        public static void printPre(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            printPre(root.left);
            printPre(root.right);
        }
    
        public static void printIn(TreeNode root) {
            if (root == null) {
                return;
            }
            printIn(root.left);
            System.out.print(root.data + " ");
            printIn(root.right);
        }
    
        public static boolean getPath(TreeNode root, int n, ArrayList<TreeNode> path) {
            if (root == null) {
                return false;
            }
            path.add(root);
            if (root.data == n) {
                return true;
            }
    
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);
    
            if (foundLeft || foundRight) {
                return true;
            } else {
                path.remove(root);
                return false;
            }
        }
    
        public static TreeNode LCA1(TreeNode root, int n1, int n2) {
            ArrayList<TreeNode> path1 = new ArrayList<>();
            ArrayList<TreeNode> path2 = new ArrayList<>();
    
            if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
                return null;
            }
    
            TreeNode lca = null;
            for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
                if (path1.get(i) == path2.get(i)) {
                    lca = path1.get(i);
                } else {
                    break;
                }
            }
    
            return lca;
        }
    
        public static TreeNode LCA2(TreeNode root, int n1, int n2){
            if(root == null){
                return null;
            }
    
            if(n1 == root.data || n2 == root.data){
                return root;
            }
    
            TreeNode leftLCA = LCA2(root.left, n1, n2);
            TreeNode rightLCA = LCA2(root.right, n1, n2);
    
            if(leftLCA == null){
                return rightLCA;
            }
            if(rightLCA == null){
                return leftLCA;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);

        int n1 = 8;
        int n2 = 9;

        TreeNode result1 = BinaryTree8.LCA1(root, n1, n2);
        TreeNode result2 = BinaryTree8.LCA2(root, n1, n2);

        System.out.println(result1.data);
        System.out.println(result2.data);
    }
}
