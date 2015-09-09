import java.util.Random;

class IntRef {
    public static int d = 0;
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

public class c2p2
{
    public static int randInt() {
        int min = 0, max = 1000;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static Node find_kthLast(Node head, IntRef ref, int k)
    {
        // dumb approach: O(n + n-k)
        // if (head == null) return Integer.MAX_VALUE;
        // Node aux = head;
        // int counter = 1;
        // while (aux.next != null)
        // {
        //     aux = aux.next;
        //     counter++;
        // }
        // aux = head;
        // while (counter != k)
        // {
        //     aux = aux.next;
        //     counter--;
        // }
        // return aux.data;

        //better iterative approach
        // if (head == null) return Integer.MAX_VALUE;
        // Node p1 = head;
        // Node p2 = head;
        // for (int i=1; i<k; ++i) { p2 = p2.next; 
        //     if (p2.next == null) return p1.data; }
        // while (p2.next != null)
        // {
        //     p1 = p1.next;
        //     p2 = p2.next;
        // }
        // return p1.data;

        //recursive
        if (head == null) return null;
        Node n = find_kthLast(head.next, ref, k);
        ref.d += 1;
        if (ref.d == k) return head;
        return n;
    }

    public static void main(String[] args)
    {
        Node head = new Node(0);
        for (int i=1; i<20; ++i) head.append(randInt());
        Node aux = head; while (aux != null){ System.out.print(aux.data+" "); aux=aux.next;}
        IntRef x = new IntRef();
        System.out.println("\n\n\n"+find_kthLast(head, x, Integer.parseInt(args[0])).data);
    }
}









