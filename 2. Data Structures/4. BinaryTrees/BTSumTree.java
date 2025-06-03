public class BTSumTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree10 {
        public static void printPre(TreeNode root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            printPre(root.left);
            printPre(root.right);
        }

        public static void printIn(TreeNode root){
            if(root == null){
                return;
            }
            printIn(root.left);
            System.out.print(root.data + " ");
            printIn(root.right);
        }

        public static void printPost(TreeNode root){
            if(root == null){
                return;
            }

            printPost(root.left);
            printPost(root.right);
            System.out.print(root.data + " ");
        }
        private static int convertToSumTreeHelper(TreeNode root){
            if(root == null){
                return 0;
            }
            int leftSum = convertToSumTreeHelper(root.left);
            int rightSum = convertToSumTreeHelper(root.right);
            int data = root.data;
            int leftData = root.left == null ? 0 : root.left.data;
            int rightData = root.right == null ? 0 : root.right.data;
            root.data = leftData + rightData + leftSum + rightSum;
            return data;
        }
        public static TreeNode convertToSumTree(TreeNode root){
            TreeNode newRoot = root;
            convertToSumTreeHelper(newRoot);
            return newRoot;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTree10.printPre(root);
        System.out.println();
        TreeNode newRoot = BinaryTree10.convertToSumTree(root);
        BinaryTree10.printPre(newRoot);
    }
}
