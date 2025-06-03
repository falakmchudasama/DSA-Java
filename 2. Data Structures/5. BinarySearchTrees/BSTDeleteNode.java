public class BSTDeleteNode {

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

    class BST2 {
        public static void inOrder(TreeNode root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static TreeNode buildBST(TreeNode root, int val){
            if(root == null){
                return new TreeNode(val);
            }
            if(root.data > val){
                root.left = buildBST(root.left, val);
            }
            else{
                root.right = buildBST(root.right, val);
            }
            return root;
        }
        public static boolean search(TreeNode root, int key) {
            if(root == null){
                return false;
            }
            if(root.data == key){
                return true;
            }
            if(root.data > key){
                return search(root.left, key);
            }
            else{
                return search(root.right, key);
            }
        }
        public static TreeNode findSuccessor(TreeNode root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }
        public static TreeNode delete(TreeNode root, int key){
            if(!search(root, key)){
                return null;
            }
            if(root.data > key){
                root.left = delete(root.left, key);
            }
            else if(root.data < key){
                root.right = delete(root.right, key);
            }
            else{
                // case 1 : leaf node
                if(root.left == null && root.right == null){
                    return null;
                }

                // case 2 : single child
                if(root.left == null){
                    return root.right;
                }
                else if(root.right == null){
                    return root.left;
                }

                // case 3 : both children
                TreeNode IS = findSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, key);

            }
            return root;
        }
    }


    public static void main(String[] args) {
        int nodes[] = {5,7,9,6,3,2,1,4,8};
        TreeNode root = new TreeNode( nodes[0] );
        for(int i = 1; i < nodes.length; i++){
            root = BST2.buildBST(root, nodes[i]);
        }
        BST2.delete(root, 4);
        BST2.inOrder(root);
    }
}
