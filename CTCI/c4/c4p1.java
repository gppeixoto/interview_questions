import java.lang.Math;

class Node<T> {
    T data;
    Node<T> l, r;

    public Node(T d) {
        data = d;
        l = null; r = null;
    }

    public void append(T data, char c) {
        if (c == 'l') l = new Node<T>(data);
        else if (c == 'r') r = new Node<T>(data);
    }
}

public class c4p1 {
    
    public static int height(Node<Integer> root) {
        if (root == null)
            return -1;
        return Math.max(height(root.l), height(root.r)) + 1;
    }

    public static boolean isBalanced(Node<Integer> root) {
        if (root == null)
            return true;
        int diff = Math.abs(height(root.l)-height(root.r));
        if (diff > 1)
            return false;
        else
            return isBalanced(root.l) && isBalanced(root.r);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(0);
        root.append(-1, 'l');
        root.append(1, 'r');
        root.r.append(2, 'r');
        root.r.r.append(3, 'r');
        root.l.append(-2, 'l');
        System.out.println(isBalanced(root));
    }
}