import java.lang.Math;

class Node {
    int data;
    Node left, right;
    public Node(int d) {
        left = null; right = null;
        data = d;
    }
}

public class c4p9 {
    public static Node build_bst(int[] sorted_array, int start, int end) {
        if (end < start)
            return null;
        int mid = (end+start)/2;
        Node n = new Node(sorted_array[mid]);
        n.left = build_bst(sorted_array, start, mid-1);
        n.right = build_bst(sorted_array, mid+1, end);
        return n;
    }

    public static int depth(Node root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }

    public static void find_sum(Node root, int[] path, int level, int val)
    {
        if (root == null) return;
        path[level] = root.data;

        int t = 0;
        for (int i = level; i >= 0; --i) {
            t += path[i];
            if (t == val) {
                print_path(path, i, level);
            }
        }
        find_sum(root.left, path, level+1, val);
        find_sum(root.right, path, level+1, val);
        path[level] = Integer.MIN_VALUE;
    }

    public static void print_path(int[] path, int start, int end) {
        for (int i=start; i < end+1; ++i)
            System.out.print(path[i] + " ");
        System.out.println();
    }

    public static void find_sum(Node root, int val) {
        int d = depth(root);
        int[] path = new int[d];
        find_sum(root, path, 0, val);
    }

    public static void main(String[] args) {
        int arg0 = Integer.parseInt(args[0]);
        int[] arr = new int[arg0];
        for (int i=0; i<arg0; ++i) arr[i] = i;
        Node p = build_bst(arr, 0, arr.length-1);
        find_sum(p, 9);
    }
}