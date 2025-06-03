import java.util.Queue;
import java.util.LinkedList;

public class BTBasics {

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

    static class BinaryTree1 {
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

        public static void printPost(TreeNode root){
            if(root == null){
                return;
            }

            printPost(root.left);
            printPost(root.right);
            System.out.print(root.data + " ");
        }

        public static void printLevel(TreeNode root){
            Queue<TreeNode> Q = new LinkedList<>();
            Q.add(root);
            Q.add(null);

            while(!Q.isEmpty()){
                TreeNode temp = Q.peek();
                if(temp != null){
                    System.out.print(temp.data + " ");
                }
                else{
                    System.out.println();
                }
                Q.remove();
                if(temp != null && temp.left != null){
                    Q.add(temp.left);
                }
                if(temp != null && temp.right != null){
                    Q.add(temp.right);
                }
                else if(!Q.isEmpty() && temp == null){
                    Q.add(null);
                }
            }
        }
    }


    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        // Declaring variable
        BinaryTree1 tree = new BinaryTree1();

        // Creation of root
        TreeNode root = tree.buildTree(nodes);

        // print pre-order
        BinaryTree1.printPre(root);
        System.out.println();

        // print in-order
        BinaryTree1.printIn(root);
        System.out.println();

        // print post-order
        BinaryTree1.printPost(root);
        System.out.println();

        System.out.println();
        // print level-order
        BinaryTree1.printLevel(root);
    }
}
