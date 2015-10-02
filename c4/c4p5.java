/*
Check if a binary tree is a BST. */
import java.util.ArrayList;
import java.util.LinkedList;
class Node {Node left, right; int data; public Node(int d){data=d;}}

public class c4p5 {

    /*
    Actual solution to the problem. Rest is
    merely for test purposes */
    public static boolean checkBST(Node root) {
        if (root == null)   //empty tree corner case
            return true;
        Node left = root.left, right = root.right;
        boolean l = (left == null) ? 
            true : (left.data <= root.data) && checkBST(root.left);
        boolean r = (right == null) ? 
            true : (root.data < right.data) && checkBST(root.right);
        return l && r;
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
        int arg0 = Integer.parseInt(args[0]);
        int[] arr = new int[arg0];
        for (int i=0; i<arg0; ++i) arr[i] = i;
        Node root = build_bst(arr, 0, arr.length-1);
        System.out.println(checkBST(root));
    }
}