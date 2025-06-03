import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BTBottomView {

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
    static class BinaryTree13 {
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
    
        static class Info {
            TreeNode root;
            int hDist;
    
            public Info(int hDist, TreeNode node){
                this.root = node;
                this.hDist = hDist;
            }
        }
    
        public static void printBottomView(TreeNode root){
            // Level order traversal
            Queue<Info> Q = new LinkedList<>();
            HashMap<Integer, TreeNode> map = new HashMap<>();
            Q.add( new Info(0, root) );
            int min = 0, max = 0;
    
            while(!Q.isEmpty()){
                Info temp = Q.remove();
                if(temp == null){
                    if(Q.isEmpty()){
                        break;
                    }
                    else{
                        Q.add(null);
                    }
                }
                
                map.put(temp.hDist,temp.root);
                if(temp.root.left != null){
                    Q.add( new Info(temp.hDist - 1, temp.root.left) );
                    min = Math.min(min, temp.hDist - 1);
                }
                if(temp.root.right != null){
                    Q.add( new Info(temp.hDist + 1, temp.root.right) );
                    max = Math.max(max, temp.hDist + 1);
                }
            }
    
            // Printing 
            for(int i = min; i <= max; i++){
                System.out.print( map.get(i).data + " " );
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);


        BinaryTree13.printBottomView(root);
    }
}
