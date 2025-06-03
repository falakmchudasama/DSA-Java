import java.util.Queue;
import java.util.LinkedList;

public class BTSideViews {
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

    static class BinaryTree12 {
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
        public static void printLeftView(TreeNode root){
            if(root == null){
                return;
            }
            Queue<TreeNode> Q = new LinkedList<>();
            Q.add(root);
            Q.add(null);
            boolean flag = false;

            while(!Q.isEmpty()){
                TreeNode temp = Q.remove();
                if(flag && temp != null){
                    flag = false;
                    System.out.print(temp.data + " ");
                }
                if(temp == null){
                    if(Q.isEmpty()){
                        break;
                    }
                    else{
                        flag = true;
                        Q.add(null);
                    }
                }
                else{
                    if(temp.left != null){
                        Q.add(temp.left);
                    }
                    if(temp.right != null){
                        Q.add(temp.right);
                    }
                }
            }
        }
        public static void printRightView(TreeNode root){
            if(root == null){
                return;
            }
            Queue<TreeNode> Q = new LinkedList<>();
            Q.add(root);
            Q.add(null);
            boolean flag = false;

            while(!Q.isEmpty()){
                TreeNode temp = Q.remove();
                if(flag && temp != null){
                    flag = false;
                    System.out.print(temp.data + " ");
                }
                if(temp == null){
                    if(Q.isEmpty()){
                        break;
                    }
                    else{
                        flag = true;
                        Q.add(null);
                    }
                }
                else{
                    if(temp.right != null){
                        Q.add(temp.right);
                    }
                    if(temp.left != null){
                        Q.add(temp.left);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        BinaryTree12.printLeftView(root);
        System.out.println();
        BinaryTree12.printRightView(root);
    }
}
