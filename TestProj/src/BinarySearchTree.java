import java.util.Scanner;
import java.io.*;

class BinarySearchTree {

    /* Class containing left
       and right child of current node
     * and key value*/
    static class Node
    {
        int key, size;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            root.size = sizeRec(root);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key <= root.key) {
            root.left = insertRec(root.left, key);
            root.size = sizeRec(root);
        }
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
            root.size = sizeRec(root);
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder()
    {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("(" + root.key + ", " + root.size + ")");
            inorderRec(root.right);
        }
    }
    int size() {return sizeRec(root);}
    int sizeRec(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return (1 + sizeRec(node.left) + sizeRec(node.right)) ;
        }
    }

    //  A function to find the kth smallest value at index k
    public int select(Node root, int k) {
        if (root == null) {
            return -1;
        }
        int lSize = sizeRec(root.left);
        if (lSize == k-1) {
            return root.key;
        }
        else if (lSize+1 < k) {
            return select(root.right, k-lSize-1);
        }
        else {
            return select(root.left, k);
        }
    }

    // Driver Code
    public static void main(String[] args) throws FileNotFoundException
    {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.insert(7);
        tree.insert(10);
        tree.insert(3);
        tree.insert(13);
        tree.insert(13);

        /*Scanner file = new Scanner(new File("input-7.2")); //CHANGE THE INPUT NUMBER HERE!
        System.out.println("File size: " + file.nextInt());
        while(file.hasNext()){
            tree.insert(file.nextInt());
        }*/

        // print inorder traversal of the BST
        tree.inorder();
        System.out.println();

        int kthSmallest = tree.select(tree.root, (tree.root.size/2 + 1)); // (tree.root.size/2 + 1)
        System.out.println("The k-th smallest value is: " + kthSmallest);

    }
}