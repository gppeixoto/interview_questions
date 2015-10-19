/*
Build a BST from a sorted array with minimal height.
    --> O(log n)
*/
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        left = null;
        right = null;
        data = d;
    }
}
public class c4p3 {

    public static void in_order(Node root) {
        if (root == null) return;
        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    /*
    This method is the actual solution to the problem, all the 
    rest is for testing purposes */
    public static Node build_bst(int[] sorted_array, int start, int end) {
        if (end < start)
            return null;

        int mid = (end+start)/2;
        Node n = new Node(sorted_array[mid]);
        n.left = build_bst(sorted_array, start, mid-1);
        n.right = build_bst(sorted_array, mid+1, end);
        return n;
    }

    public static int height(Node root) {
        if (root == null)
            return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
        
    public static void main(String[] args) {
        int arg0 = Integer.parseInt(args[0]);
        int[] arr = new int[arg0];
        for (int i=0; i<arg0; ++i) arr[i] = i;
        Node root = build_bst(arr, 0, arr.length-1);
        in_order(root);
        System.out.println("\n"+height(root));
    }
}