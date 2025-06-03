import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BTTopView {

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
    static class BinaryTree6 {
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
    
        public static void printTopView(TreeNode root){
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
                if(!map.containsKey(temp.hDist)){
                    map.put(temp.hDist,temp.root);
                }
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
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree6 tree = new BinaryTree6();
        TreeNode root1 = tree.buildTree(nodes);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.left.left = new TreeNode(6);
        root2.left.left.left.left = new TreeNode(7);

        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(8);
        root2.right.right = new TreeNode(9);
        root2.right.right.right =  new TreeNode(10);
        root2.right.right.right.right = new TreeNode(11);

        BinaryTree6.printTopView(root1);
        BinaryTree6.printTopView(root2);
    }
}
