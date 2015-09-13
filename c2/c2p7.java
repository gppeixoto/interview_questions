import java.util.Random;
import java.util.Stack;

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

class MyNode<T> {
    T data;
    MyNode<T> next;
    public MyNode() {data = null; next = null;}
    public MyNode(T d) {data = d; next = null;}
}

class MyStack<T> {
    MyNode<T> top;
    public MyStack() {top = null;}
    public MyStack(T d) {top = new MyNode<T>(d);}

    public void push(T d) {
        if (top == null) top = new MyNode<T>(d);
        else {
            MyNode<T> n = new MyNode<T>(d);
            n.next = top;
            top = n;
        }}

    public T pop() {
        if (top == null) return null;
        else {
            T ret = top.data;
            top = top.next;
            return ret;
        }}
}

public class c2p7
{
    public static int randInt(int x) {
        int min = 0, max = x;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static boolean checkpal(Node head)
    {
        MyStack<Integer> s = new MyStack<Integer>();
        Node p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            s.push(p1.data);
            p1 = p1.next; p2 = p2.next.next;
        }
        if (p2 != null) p1 = p1.next;

        while (p1 != null) {
            int top = s.pop();
            if (top != p1.data) return false;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        for (int i=1; i<4; ++i) head.append(randInt(3));
        Node aux = head; while (aux != null){ System.out.print(aux.data+" "); aux=aux.next;} System.out.println();
        System.out.println(checkpal(head));
    }
}