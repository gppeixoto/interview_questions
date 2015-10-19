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

public class ll
{
    public static Node del(Node head, int v)
    {
        Node aux = head;
        if (head.data == v) head = head.next;
        else {
            while (aux.next != null) {
                if (aux.next.data == v) {aux.next = aux.next.next; return head;}
                aux = aux.next;
        }}
        return head;
    }

    public static void main(String[] args)
    {
        Node a = new Node(0);
        for (int i=1; i<11; ++i) a.append(i);
        a = del(a, Integer.parseInt(args[0]));
        Node aux = a;
        while (aux != null)
        {
            System.out.print(aux.data + " ");
            aux = aux.next;
        }
        System.out.println();
    }
}