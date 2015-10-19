/*
Find the minimum common ancestor between two nodes in a tree,
without using any additional data structure besides the tree itself
*/
class Node {
    int data; Node left, right; 
    public Node(int d){data=d; left=null; right = null;}}


public class c4p7 {

    public static boolean isPath(Node from, Node to) {
        if (from == null || to == null)
            return false;
        if (from == to)
            return true;
        return isPath(from.left, to) || isPath(from.right, to);
    }

    /*
    CTCI's version, less calls */
    public static Node find_aux(Node root, Node p, Node q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        boolean is_p_on_left = isPath(root.left, p);
        boolean is_q_on_left = isPath(root.left, q);
        if (is_p_on_left != is_q_on_left){
            return root;
        }
        Node child = is_p_on_left ? root.left : root.right;
        return find_aux(child, p, q);
    }

    public static Node find_ancestor(Node root, Node p, Node q) {
        if (!isPath(root, p) && !isPath(root, q))
            return null;
        return find_aux(root, p, q);
    }

    public static Node build_bst(int[] sorted_array, int start, int end) {
        if (end < start)
            return null;
        int mid = (end+start)/2;
        Node n = new Node(sorted_array[mid]);
        n.left = build_bst(sorted_array, start, mid-1);
        n.right = build_bst(sorted_array, mid+1, end);
        return n;
    }

    /*
    My version, correct but sub-optimal */
    public static Node find_minAncestor(Node root, Node p, Node q) {
        if (root == null)
            return null;
        if (p == q)
            return p;
    
        boolean branchL = isPath(root.left, p) && isPath(root.left, q);
        if (branchL)
            return find_minAncestor(root.left, p, q);
    
        boolean branchR = isPath(root.right, p) && isPath(root.right, q);
        if (branchR)
            return find_minAncestor(root.right, p, q);
    
        if (isPath(root, p) && isPath(root, q))
            return root;
        else
            return null;
    }

    public static void in_order(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        in_order(root.left);
        in_order(root.right);
    }

    public static void main(String[] args) {
        int arg0 = Integer.parseInt(args[0]);
        int[] arr = new int[arg0];
        for (int i=0; i<arg0; ++i) arr[i] = i;
        Node root = build_bst(arr, 0, arr.length-1);
        Node p = root.left;
        Node q = root.right.left.left;
        in_order(root); System.out.println();
        System.out.println(find_ancestor(root, p, q).data);
        System.out.println(find_minAncestor(root, p, q).data);
    }    
}