public class BTKthAncestor {
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

    static class BinaryTree11 {
        public TreeNode buildTree(int[] nodes, int[] index) {
            if (index[0] == nodes.length || nodes[index[0]] == -1) {
                index[0]++;
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[index[0]]);
            index[0]++;
            newNode.left = buildTree(nodes, index);
            newNode.right = buildTree(nodes, index);

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

        public static int KthAncestor(TreeNode root, int n, int k) {
            if (root == null) {
                return -1;
            }

            if (root.data == n || root.left != null && root.left.data == n || root.right != null && root.right.data == n) {
                return 0;
            }

            int leftAncestor = KthAncestor(root.left, n, k);

            if (leftAncestor != -1 && leftAncestor + 1 == k) {
                System.out.println(root.data);
                return -1; // Stop further exploration
            }

            int rightAncestor = KthAncestor(root.right, n, k);

            if (rightAncestor != -1 && rightAncestor + 1 == k) {
                System.out.println(root.data);
                return -1; // Stop further exploration
            }

            return (leftAncestor != -1) ? leftAncestor + 1 : (rightAncestor != -1) ? rightAncestor + 1 : -1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        int n = 10;
        int k = 2;
        BinaryTree11.KthAncestor(root, n, k);
    }
}
