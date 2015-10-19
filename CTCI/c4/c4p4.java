/*
Create D linked lists such that each list_d will contain every note
at depth d */
import java.util.ArrayList;
import java.util.LinkedList;
class Node {Node left, right; int data; public Node(int d){data=d;}}

public class c4p4 {
    public static void in_order(Node root) {
        if (root == null) return;
        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    public static void inOrder(Node root) {
        in_order(root);
        System.out.println();
    }

    /*
    Actual solution to the problem. Rest is
    merely for test purposes */
    public static int depth(Node root, ArrayList<LinkedList<Node>> arr) {
        if (root == null) return 0;
        int h = Math.max(depth(root.left, arr), depth(root.right, arr))+1;
        if (arr.size() == h-1) {
            arr.add(new LinkedList<Node>());
            arr.get(h-1).add(root);
        }
        else arr.get(h-1).add(root);
        return h;
    }

    public static void printList(ArrayList<LinkedList<Node>> lists) {
        for (int i=0; i < lists.size(); ++i) {
            System.out.println("depth: " + i);
            for (Node n : lists.get(i)) System.out.print(n.data + " ");
            System.out.println();
        }
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

    public static void main(String[] args) {
        // System.out.println(test.size());
        int arg0 = Integer.parseInt(args[0]);
        int[] arr = new int[arg0];
        for (int i=0; i<arg0; ++i) arr[i] = i;
        Node root = build_bst(arr, 0, arr.length-1);
        inOrder(root);
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        int build = depth(root, lists);
        printList(lists);
    }
}