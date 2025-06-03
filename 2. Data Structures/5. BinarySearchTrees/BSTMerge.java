import java.util.ArrayList;

public class BSTMerge {

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

    static class BST8 {
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

        public static void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void getArray(TreeNode root, ArrayList<Integer> array){
            if(root == null){
                return;
            }
            getArray(root.left, array);
            array.add(root.data);
            getArray(root.right, array);
        }

        public static ArrayList<Integer> merge(ArrayList<Integer> array1, ArrayList<Integer> array2){
            ArrayList<Integer> array = new ArrayList<>();
            int ptr1 = 0;
            int ptr2 = 0;
            while (ptr1 < array1.size() && ptr2 < array2.size()) {
                if(array1.get(ptr1) <= array2.get(ptr2)){
                    array.add(array1.get(ptr1));
                    ptr1++;
                }
                else if(array2.get(ptr2) < array1.get(ptr1)){
                    array.add(array2.get(ptr2));
                    ptr2++;
                }
            }
            while(ptr1 < array1.size()){
                array.add(array1.get(ptr1));
                ptr1++;
            }
            while(ptr2 < array2.size()){
                array.add(array2.get(ptr2));
                ptr2++;
            }
            return array;
        }

        public static TreeNode createTree(ArrayList<Integer> array, int start, int end){
            if(start > end){
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(array.get(mid));

            root.left = createTree(array, start, mid-1);
            root.right = createTree(array, mid+1, end);

            return root;
        }

        public static TreeNode merge(TreeNode root1, TreeNode root2){
            // Step 1 : get arrays
            ArrayList<Integer> array1 = new ArrayList<>();
            getArray(root1, array1);
            ArrayList<Integer> array2 = new ArrayList<>();
            getArray(root2, array2);

            // Step 2 : merge arrays
            ArrayList<Integer> array = merge(array1, array2);

            // Step 3 : create the tree
            TreeNode root = createTree(array, 0, array.size()-1);

            return root;
        }
    }

    public static void main(String[] args) {
        int nodes1[] = {2,1,4};
        int nodes2[] = {9,3,12};

        TreeNode root1 = new TreeNode( nodes1[0] );
        TreeNode root2 = new TreeNode( nodes2[0] );

        for(int i = 1; i < nodes1.length; i++){
            root1 = BST8.buildBST(root1, nodes1[i]);
        }
        for(int i = 1; i < nodes2.length; i++){
            root2 = BST8.buildBST(root2, nodes2[i]);
        }
        TreeNode root = BST8.merge(root1, root2);

        BST8.preOrder(root);
        System.out.println();
        BST8.inOrder(root1);
        System.out.println();
        BST8.inOrder(root2);
        System.out.println();

    }
}
