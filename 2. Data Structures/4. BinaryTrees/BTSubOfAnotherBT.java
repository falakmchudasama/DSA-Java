public class BTSubOfAnotherBT {

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
    static class BinaryTree5 {
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
    
        public static boolean isIdentical(TreeNode root1, TreeNode root2){
            if(root1 == null && root2 == null){
                return true;
            }
            else if(root1 == null || root2 == null){
                return false;
            }
            else if(root1.data == root2.data){
                return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
            }
            return false;
        }
    
        public static boolean isSubtree(TreeNode root1, TreeNode root2){
            if(root1 == null){
                return false;
            }
            if(root1.data == root2.data){
                return isIdentical(root1, root2);
            }
            return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
        }
    }


    public static void main(String[] args) {
        int nodes1[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        int nodes2[] = {2,4,-1,-1,5,-1,-1};

        BinaryTree5 tree = new BinaryTree5();
        BinaryTree5 subTree = new BinaryTree5();

        TreeNode root = tree.buildTree(nodes1);
        TreeNode subRoot = subTree.buildTree(nodes2);

        BinaryTree5.printIn(root);
        System.out.println();

        BinaryTree5.printIn(subRoot);
        System.out.println();

        boolean result = BinaryTree5.isSubtree(root, subRoot);

        System.out.println(result);
    }
}
