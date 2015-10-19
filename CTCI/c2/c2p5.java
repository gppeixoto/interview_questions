/*
7 + 5 = 12
(7+5)/10 = 1 <-- carry
(7+5)%10 = 2 <-- normal
*/

class IntRef {
    public static int x = 0;
}

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

public class c2p5
{

    public static Node add(Node p1, Node p2, int carry)
    {
        if (p1 == null && p2 == null && carry == 0) return null;
        int sum = carry;
        if (p1 != null) sum += p1.data;
        if (p2 != null) sum += p2.data;
        Node res = new Node(sum%10);
        if (p1 != null || p2 != null || sum != 0)
        {
            res.next = add( p1 == null ? null : p1.next,
                            p2 == null ? null : p2.next,
                            sum > 10 ? 1 : 0
                        );
        }
        return res;
    }

    
    
    public static void main(String[] args) {
        Node p1 = new Node(9);
        p1.append(9);
        Node p2 = new Node(9);
        p2.append(9);
        Node s = add(p1, p2, 0);
        while (s!=null){System.out.print(s.data); s=s.next;} System.out.println();
    }
}



