public class BTHeight {

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
    static class BinaryTree2 {
        private int idx = -1;
        public TreeNode buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
    
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
    
            return newNode;
        }
    
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
    
        public static int getHeight(TreeNode root){
            if(root == null){
                return 0;
            }
    
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
    
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,3,4,5,6,-1,-1,-1,-1,-1,-1,-1};
        BinaryTree2 tree = new BinaryTree2();

        TreeNode root = tree.buildTree(nodes);
        int height = BinaryTree2.getHeight(root);
        System.out.println(height);
        BinaryTree2.printIn(root);
    }
}
