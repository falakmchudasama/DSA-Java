import java.util.ArrayList;


public class BSTConvertion {
    
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

    class BST7 {
        public static void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        public static void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }


        private static void createInOrder(TreeNode root, ArrayList<Integer> array){
            if(root == null){
                return;
            }
            createInOrder(root.left, array);
            array.add(root.data);
            createInOrder(root.right, array);
        }

        public static TreeNode buildBST(ArrayList<Integer> nodes, int start, int end) {
            if(start > end){
                return null;
            }
            int mid = (start + end) / 2;

            TreeNode Node = new TreeNode( nodes.get(mid) );
            Node.left = buildBST(nodes, start, mid-1);
            Node.right = buildBST(nodes, mid+1, end);

            return Node;
        }

        public static TreeNode convert(TreeNode root){
            ArrayList<Integer> array = new ArrayList<>();

            createInOrder(root, array);
            TreeNode newNode = buildBST(array, 0, array.size()-1);

            return newNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(6);
        root1.left.left = new TreeNode(5);
        root1.left.left.left = new TreeNode(3);

        root1.right = new TreeNode(10);
        root1.right.right = new TreeNode(11);
        root1.right.right.right = new TreeNode(12);

        TreeNode root2 = BST7.convert(root1);
        BST7.preOrder(root2);
    }
}
