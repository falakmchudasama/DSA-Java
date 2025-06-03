public class BTDFS {
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

    static class BinaryTree11 {
        public static void printPre(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            printPre(root.left);
            printPre(root.right);
        }

        public static  void printIn(TreeNode root) {
            if (root == null) {
                return;
            }
            printIn(root.left);
            System.out.print(root.data + " ");
            printIn(root.right);
        }
        static boolean flag = false;
        public static void printDFS(TreeNode root, String str) {
            if (root == null) {
                if(flag == false){
                    flag = true;
                    return;                 }
                else{
                    str += "null";
                    System.out.println(str);
                    flag = false;
                    return;
                }
            }
            printDFS(root.left, str + root.data + " -> ");
            printDFS(root.right, str + root.data + " -> ");
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("DFS Traversal:");
        BinaryTree11.printDFS(root, "");
    }
}
