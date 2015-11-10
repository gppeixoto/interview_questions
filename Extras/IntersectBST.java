import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    void insert(int val) {
        Node aux = this;
        Node prev = aux;
        while (aux != null ) {
            prev = aux;
            if (val > aux.val) aux = aux.right;
            else aux = aux.left;
        }
        aux = new Node(val);
        if (val > prev.val) prev.right = aux;
        else prev.left = aux;
    }
}

public class IntersectBST {
    static ArrayList<Integer> intersect(Node n, Node m) {
        if (n == null || m == null)
            return null;
        
        Node p = n, q = m;
        ArrayList<Integer> common = new ArrayList<Integer>();
        Stack<Node> sp = new Stack<Node>(), sq = new Stack<Node>();

        while (true) {
            if (p != null) {
                sp.push(p);
                p = p.left;
            } else if (q != null) {
                sq.push(q);
                q = q.left;
            } else if (!sp.empty() && !sq.empty()) {
                p = sp.peek();
                q = sq.peek();
                if (sp.peek().val < sq.peek().val) {
                    sp.pop();
                    p = p.right;
                } else if (sp.peek().val > sq.peek().val) {
                    sq.pop();
                    q = q.right;
                } else {
                    common.add(p.val);
                    sp.pop(); sq.pop();
                    p = p.right; q = q.right;
                }
            } else {
                break;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.insert(3);
        root.insert(2);
        root.insert(12);
        root.insert(7);

        Node root2 = new Node(6);
        root2.insert(3);
        root2.insert(8);
        root2.insert(15);
        root2.insert(2);
        ArrayList<Integer> common = intersect(root, root2);
        for (Integer i : common) System.out.print(i+" ");
    }
}