import java.util.Queue;
import java.util.LinkedList;

public class BTKthLevel {

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
    static class BinaryTree7 {
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
    
        public static void KthLevelIterative(TreeNode root, int k){
            int count = 1;
            Queue<TreeNode> Q = new LinkedList<>();
            Q.add(root);
            Q.add(null);
    
            while(!Q.isEmpty()){
                TreeNode temp = Q.remove();
                if(temp == null){
                    count++;
                    if(!Q.isEmpty()){
                        Q.add(null);
                    }
                }
                else{
                    if(count == k){
                        System.out.print(temp.data + " ");
                    }
                    if(temp.left != null){
                        Q.add(temp.left);
                    }
                    if(temp.right != null){
                        Q.add(temp.right);
                    }
                }
                if(count > k){
                    break;
                }
            }
            System.out.println();
        }
    
        public static void KthLevelRecursive(TreeNode root, int level, int k){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data + " ");
                return;
            }
            KthLevelRecursive(root.left, level+1, k);
            KthLevelRecursive(root.right, level+1, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int k = 2;
        BinaryTree7.KthLevelIterative(root, k);
        BinaryTree7.KthLevelRecursive(root, 1, k);
    }
}
