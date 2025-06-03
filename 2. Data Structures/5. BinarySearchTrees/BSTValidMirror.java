public class BSTValidMirror {

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
    
    class BST5 {
        public static void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    
        public static TreeNode buildBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.data > val) {
                root.left = buildBST(root.left, val);
            } else {
                root.right = buildBST(root.right, val);
            }
            return root;
        }
    
        public static void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    
        public static boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            }
            if ((min != null && root.data <= min.data) || (max != null && root.data >= max.data)) {
                return false;
            }
            return isValid(root.left, min, root) && isValid(root.right, root, max);
        }
    
        public static TreeNode mirror(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode mirroredLeft = mirror(root.left);
            TreeNode mirroredRight = mirror(root.right);
    
            TreeNode mirroredRoot = new TreeNode(root.data);
            mirroredRoot.left = mirroredRight;
            mirroredRoot.right = mirroredLeft;
    
            return mirroredRoot;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {5, 7, 8, 9, 1, 2, 3, 6, 4};
        TreeNode root1 = new TreeNode(nodes[0]);

        for (int i = 1; i < nodes.length; i++) {
            root1 = BST5.buildBST(root1, nodes[i]);
        }

        boolean result = BST5.isValid(root1, null, null);
        System.out.println(result);

        TreeNode root2 = BST5.mirror(root1);

        BST5.inOrder(root1);
        System.out.println();
        BST5.inOrder(root2);
    }
}
