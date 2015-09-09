class node
{
    int v;
    node next;
    public node(int x) {v=x; next=null;}
}

class ll
{
    node head;
    public ll() {head = null;}
    public ll(int x) {head = new node(x);}
    public ll(node n) {head = n;}
    public ll(ll list) {head = list.head;}

    public void enqueue(node n)
    {
        if (head == null){head = n; return;}
        node aux = head;
        while (aux.next != null) aux = aux.next;
        aux.next = n;
    }

    public void enqueue(int x)
    {
        if (head == null) {head = new node(x); return;}
        node aux = head;
        while (aux.next != null) aux = aux.next;
        aux.next = new node(x);
    }

    public void print()
    {
        node aux = head;
        while (aux!=null) {System.out.print(aux.v + " "); aux=aux.next;}
        System.out.println();
    }

    public ll partition(int x)
    {
        left = 
        while (p != null)
        {
            if (p.v < x) 
            p = p.next;
        }
    }
}

public class ccpp  {
    public static void main(String[] args) {
        ll l = new ll();
        for (int i=20; i>=0; --i) l.enqueue(i);
        l.print();
    }
}