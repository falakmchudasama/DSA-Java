public class AVLTCreation {

    static class AVLTreeNode {
        int data;
        int height;
        AVLTreeNode left;
        AVLTreeNode right;

        public AVLTreeNode(int val){
            this.data = val;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    static class AVLT1 {
        public static void printIn(AVLTreeNode root){
            if(root == null){
                return;
            }
            printIn(root.left);
            System.out.print(root.data + " ");
            printIn(root.right);
        }
        public static void printPre(AVLTreeNode root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            printPre(root.left);
            printPre(root.right);
        }
        public static int getHeight(AVLTreeNode root){
            if(root == null){
                return 0;
            }
            return root.height;
        }

        public static int getBalance(AVLTreeNode root){
            if(root == null){
                return 0;
            }
            return getHeight(root.left) - getHeight(root.right);
        }

        public static AVLTreeNode leftRotate(AVLTreeNode x){
            AVLTreeNode y = x.right;
            AVLTreeNode T2 = y.left;

            // Perform rotation
            y.left = x;
            x.right = T2;

            // update heights
            x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
            y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

            return y;
        }

        public static AVLTreeNode rightRotate(AVLTreeNode y){
            AVLTreeNode x = y.left;
            AVLTreeNode T2 = x.right;

            // Perform rotation
            x.right = y;
            y.left = T2;

            // update heights
            x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
            y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

            return x;
        }

        public static AVLTreeNode insert(AVLTreeNode root, int key){
            if(root == null){
                return new AVLTreeNode(key);
            }
            if(key < root.data){
                root.left = insert(root.left, key);
            }
            else if(key > root.data){
                root.right = insert(root.right, key);
            }
            else{
                return root; 
            }

            // update root height
            root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

            // get balance factor
            int bFactor = getBalance(root);

            // LL case
            if(bFactor > 1 && key < root.left.data){
                return rightRotate(root);
            }

            // RR case
            if(bFactor < -1 && key > root.right.data){
                return leftRotate(root);
            }

            // LR case
            if(bFactor > 1 && key > root.left.data){
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            // RL case
            if(bFactor < -1 && key < root.right.data){
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root; // return AVL tree if balanced
        }
    }

    public static void main(String[] args) {
        AVLTreeNode root = null;
        AVLT1.insert(root, 1);
        AVLT1.insert(root, 2);
        AVLT1.insert(root, 3);
        AVLT1.insert(root, 4);
        AVLT1.insert(root, 5);
        AVLT1.insert(root, 6);
        AVLT1.insert(root, 7);
        AVLT1.insert(root, 8);

        AVLT1.printIn(root);
        System.out.println();
        AVLT1.printPre(root);
    }
}
