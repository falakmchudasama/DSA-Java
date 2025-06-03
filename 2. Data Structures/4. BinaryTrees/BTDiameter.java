public class BTDiameter {

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
    static class BinaryTree4 {
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
    
        // TC : O(n^2)
        public static int getDiameter1(TreeNode root){
            if(root == null){
                return 0;
            }
    
            int lDiameter = getDiameter1(root.left);
            int rDiameter = getDiameter1(root.right);
            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);
    
            int rootDiameter = leftH + rightH + 1;
    
            return Math.max( Math.max(lDiameter, rDiameter), rootDiameter);
        }
    
        // TC : O(n)
        static class TreeInfo {
            int diameter;
            int height;
            public TreeInfo(int d, int h){
                this.diameter = d;
                this.height = h;
            }
        }
    
        private static TreeInfo getDiameter2Helper(TreeNode root){
            if(root == null){
                return new TreeInfo(0, 0);
            }
    
            TreeInfo leftInfo = getDiameter2Helper(root.left);
            TreeInfo rightInfo = getDiameter2Helper(root.right);
    
            int diameter = Math.max( Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1 );
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
    
            TreeInfo result = new TreeInfo(diameter, height);
    
            return result;
        }
    
        public static int getDiameter2(TreeNode root){
            TreeInfo result = getDiameter2Helper(root);
            return result.diameter;
        }
    }
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,-1};
        BinaryTree4 tree = new BinaryTree4();

        TreeNode root = tree.buildTree(nodes);

        int diameter = BinaryTree4.getDiameter1(root);
        System.out.println(diameter);
        diameter = BinaryTree4.getDiameter2(root);
        System.out.println(diameter);
        BinaryTree4.printIn(root);
    }
}
