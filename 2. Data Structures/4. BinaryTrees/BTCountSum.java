public class BTCountSum {

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
    static class BinaryTree3 {
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
    
        public static int getNodes(TreeNode root){
            if(root == null){
                return 0;
            }
    
            int leftNodes = getNodes(root.left);
            int rightNodes = getNodes(root.right);
    
            return leftNodes + rightNodes + 1;
        }
    
        public static int getSum(TreeNode root){
            if(root == null){
                return 0;
            }
    
            int leftSum = getSum(root.left);
            int rightSum = getSum(root.right);
    
            return leftSum + rightSum + root.data;
        }
    }
    

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree3 tree = new BinaryTree3();

        TreeNode root = tree.buildTree(nodes);
        BinaryTree3.printIn(root);
        System.out.println();

        int number = BinaryTree3.getNodes(root);
        int sum = BinaryTree3.getSum(root);

        System.out.println(number);
        System.out.println(sum);
    }
}
