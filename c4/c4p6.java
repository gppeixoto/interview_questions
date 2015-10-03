/*
Given a node (assume nodes have links to its parent) in a BST,
find the in-order suc
*/
class Node {
    Node parent, left, right;
    int data;
    public Node(int d) {data = d; parent = null; left = null; right = null;}
}

public class c4p6 {
    public static Node find_min(Node root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return find_min(root.left);
    }

    public static Node find_next(Node root) {
        if (root == null)
            return null;
        if (root.right != null)
            return find_min(root.right);
        Node curr = root, parent = curr.parent;
        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static void main(String[] args) {

    }
}