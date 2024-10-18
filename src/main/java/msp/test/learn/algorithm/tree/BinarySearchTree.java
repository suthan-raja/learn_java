package msp.test.learn.algorithm.tree;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int value) {
        root = insertRec(root , value);
    }

    public TreeNode insertRec(TreeNode node , int value){

        if(node == null){
            return new TreeNode(value);
        }

        if( value < node.value ){
            node.left = insertRec(node.left , value);
        }else if( value > node.value ){
            node.right = insertRec(node.right , value);
        }

        return node;
    }

    public void inOrder(TreeNode node){
        inOrderRecords(root);
    }

    public void inOrderRecords(TreeNode node){
        if(node != null){
            inOrderRecords(node.left);
            System.out.print(node.value + " ");
            inOrderRecords(node.right);
        }
    }

    public void preOrder(){
        preOrderTraversal(root);
    }

    public void preOrderTraversal(TreeNode root){

        if(root != null){
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

    }

    public void postOrder(){
        postOrderTraversal(root);
    }

    public void postOrderTraversal(TreeNode root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    public boolean searchRecords(int value){
        return search(root, value);
    }

    public boolean search(TreeNode root , int value) {
        if(root == null){
            return false;
        }

        if(value == root.value){
            return true;
        }

        return value < root.value ? search(root.left, value) : search(root.right, value);

    }

    public int findMin(){
        if(root == null){
            return -1;
        }

        return findMinRecord(root);
    }

    public int findMinRecord(TreeNode root){

        return root.left == null ? root.value : findMinRecord(root.left);
    }

    public int findMax(){
        if(root == null){
            return -1;
        }

        return findMaxRecord(root);
    }

    public int findMaxRecord(TreeNode root){
        return root.right == null ? root.value : findMaxRecord(root.right);
    }

    public void delete(int value){
        root = deleteRecord(root , value);
    }

    public TreeNode deleteRecord(TreeNode root, int value){

        if(root == null){
            return null;
        }

        if(value == root.value){
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.value = findMinRecord(root.right);
            root.right = deleteRecord(root.right, value);
        }else if(value < root.value){
            root.left = deleteRecord(root.left, value);
        }else {
            root.right = deleteRecord(root.right, value);
        }

        return root;
    }


    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(11);
        tree.insert(209);
        tree.insert(33);
        tree.insert(42);
        tree.insert(5);

        tree.inOrder(tree.root);

        System.out.println("----------------------------");

        boolean val = tree.searchRecords(42);
        System.out.println("Val : "+val);

        System.out.println(tree.findMin());

        System.out.println(tree.findMax());


        System.out.println("----------------------------");

        tree.preOrder();

        System.out.println("----------------------------");

        tree.delete(11);

        System.out.println("----------------------------");

        tree.preOrder();

        System.out.println("----------------------------");

        tree.postOrder();

    }
}
