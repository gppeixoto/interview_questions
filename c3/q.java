/*
queue implementation
*/

class QNode<T> {
    T item;
    QNode<T> next;
    public QNode(T item) {
        this.item = item;
        this.next = null;
    }
}

public class q<T> {
    QNode<T> head, tail;
    public q(){head = null; tail=null;}

    public void enqueue(T item) {
        QNode<T> n = new QNode<T>(item);
        if (head == null){head = n; tail = head; head.next=null; return;}
        tail.next = n;
        tail = n;
    }

    public T dequeue() {
        if (head == null) return null;
        T ret = head.item;
        head = head.next;
        if (head == null) tail = null;
        return ret;
    }
}