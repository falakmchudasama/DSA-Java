public class BSTLargestBST {

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

    static class BST8 {
        static int maxSize = 0;

        static class Info {
            boolean valid;
            int size;
            int min;
            int max;

            public Info(boolean valid, int size, int min, int max) {
                this.valid = valid;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }

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

        public static Info largestBST(TreeNode root) {
            if (root == null) {
                return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);

            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

            if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
                return new Info(false, size, min, max);
            }
            if (leftInfo.valid && rightInfo.valid) {
                maxSize = Math.max(maxSize, size);
                return new Info(true, size, min, max);
            }
            return new Info(false, size, min, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.right = new TreeNode(20);
        root.left.left = new TreeNode(5);

        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        BST8.largestBST(root);
        System.out.println(BST8.maxSize);
    }
}
