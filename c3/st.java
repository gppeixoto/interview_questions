/*
stack implementation
*/

class SNode<T> {
    T item;
    SNode<T> next;
    public SNode(T item) {
        this.item = item;
        this.next = null;
    }
}

public class st<T> {
    SNode<T> top;
    public st(){top = null;}

    public void push(T item) {
        SNode<T> n = new SNode<T>(item);
        if (top == null) {top = n; return;}
        top.next = n;
        top = n;
    }

    public T pop() {
        if (top == null) {return null;}
        T ret = top.item;
        top = top.next;
        return ret;
    }

    public T peek() {return top.item;}
}