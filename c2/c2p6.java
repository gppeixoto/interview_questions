class Node {
        int data;
        Node next;
        public Node(int d) {next = null; data = d;}
        public void append(int v) {
            Node n = new Node(v);
            Node curr = this;
            if (curr == null) curr = n;
            else {
                while (curr.next != null) curr = curr.next;
                curr.next = n;
        }}
}

public class c2p6
{
    public static Node detectloop(Node head) {
        Node p1 = head, p2 = head; boolean fst = true, loop = false;
        while (p1 != null && p2 != null) {
            if (p2.next == null) break;
            if (p1 == p2 && !fst) {loop = true; break;}
            if (fst) fst = !fst;
            p1 = p1.next; p2 = p2.next.next;
        }
        if (loop) {
            p1 = head;
            while (p1 != p2) {p1 = p1.next; p2 = p2.next;}
        }
        Node ret = loop ? p1 : null;
        return ret;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n3;
        System.out.println(detectloop(n3).data);
    }
}