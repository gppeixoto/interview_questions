import java.util.Random; 

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

public class c2p4
{
    public static int randInt() {
        int min = 0, max = 40;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static Node partition(Node head, int x) {
        System.out.println("x: " + x);
        Node l = null, r = null, p = head;
        while (p != null) {
            if (p.data < x) {
                if (l == null) l = new Node(p.data);
                else l.append(p.data); //creating new nodes
            } else {
                if (r == null) r = new Node(p.data);
                else r.append(p.data);
            }
            p = p.next;
        }
        Node aux = l;
        while (aux.next != null) aux = aux.next;
        aux.next = r;
        return l;
    }

    public static void main(String[] args)
    {
        Node head = new Node(0);
        for (int i=1; i<20; ++i) head.append(randInt());
        Node aux = head; while (aux != null){ System.out.print(aux.data+" "); aux=aux.next;} System.out.println();
        aux = partition(head, Integer.parseInt(args[0]));
        while (aux != null){ System.out.print(aux.data+" "); aux=aux.next;} System.out.println();
        System.out.println();
    }
}