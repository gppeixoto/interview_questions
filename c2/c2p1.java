import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;

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

public class c2p1
{
    public static int randInt() {
        int min = 0, max = 9;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void deldups(Node head)
    {
        // HashSet<Integer> set = new HashSet<Integer>();
        // set.add(head.data);
        // Node aux = head.next;
        // Node prev = head;
        // while (aux.next != null)
        // {
        //     if (set.contains(aux.data)) {prev.next = aux.next;}
        //     else set.add(aux.data);
        //     aux = aux.next;
        //     prev = prev.next;
        // }
        HashSet<Integer> set = new HashSet<Integer>();
        Node prev = null;
        while (head != null)
        {
            if (set.contains(head.data)) prev.next = head.next;
            else {set.add(head.data); prev = head;}
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(0);
        for (int i=0; i<20; ++i) head.append(randInt());
        Node aux = head; while (aux != null){ System.out.print(aux.data+" "); aux=aux.next;}
        System.out.println();
        deldups(head);
        aux = head; while (aux != null){ System.out.print(aux.data+" "); aux=aux.next;}
        System.out.println();
    }
}

