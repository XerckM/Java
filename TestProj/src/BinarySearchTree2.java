public class BinarySearchTree2 {
    static class Node {
        int key, size, count;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
            size = 1;
            count = 0;
        }
    }
    Node root;
    BinarySearchTree2() {
        root = null;
    }
    public void insert(int key) {
        root = insertRec(root, key);
    }
    // Function to insert a new node with given key in BST 
    public static Node insertRec(Node root, int key)
    {
        // If the tree is empty, return a new node
        if (root == null) {
            return new Node(key);
        }

        // Increment size and return
        if (key == root.key) {
            root.size++;
            return root;
        }
    
        /* Otherwise, recur down the tree */
        if (key < root.key) {
            root.left = insertRec(root.left, key);
            root.size++;
            root.count++;
        }
        else {
            root.right = insertRec(root.right, key);
            root.size++;
        }
        return root;
    }
    public void inorder(){
        inorderRec(root);
    }
        // A utility function to do inorder traversal of BST
    public void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("(" + root.key + ", " + root.size + ")");
            inorderRec(root.right);
        }
    }
    public Node select(Node root, int k) {
        if (root == null) {
            return null;
        }
        // returns k-th smallest element if found in current
        int size = root.count + 1;
        if (size == k) {
            return root;
        }
        // returns k-th smallest element if found in left subtree
        if (size > k) {
            return select(root.left, k);
        }
        // else returns k-th smallest element in right subtree
        return select(root.right, k-size);
    }
    public static void main(String[] args) {
        BinarySearchTree2 tree = new BinarySearchTree2();
        tree.insert(7);
        tree.insert(10);
        tree.insert(3);
        tree.insert(13);
        tree.insert(11);

        tree.inorder();
        System.out.println(tree.root.size);
        Node kth = tree.select(tree.root, 3);
        if (kth == null) {
            System.out.println(-1);
        }
        else {
            System.out.println(kth.key);
        }
    }
}