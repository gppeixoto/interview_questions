import java.util.Stack;
import java.util.Vector;

/*
queue implementation using two stacks
*/
class MyQueue<T> {
    Stack<T> back, front;
    public MyQueue(){
        back = new Stack<T>();
        front = new Stack<T>();
    }

    public void enqueue(T item) {
        back.push(item); }
    
    public T dequeue() {
        if (front.empty())
            while (!back.empty())
                front.push(back.pop());
        return front.pop(); }

    public T peek() {
        if (front.empty())
            while (!back.empty())
                front.push(back.pop());
        return front.peek(); }

    public void print(){
        while (!front.empty()) System.out.print(front.pop() + " ");
        while (!back.empty()) System.out.print(back.pop() + " ");
    }
}

public class c3p5 {
    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<Integer>();
        for (int i=1; i<=5; ++i) q.enqueue(i);
        q.dequeue();
        q.enqueue(1);
        q.dequeue();
        q.print();
    }
}