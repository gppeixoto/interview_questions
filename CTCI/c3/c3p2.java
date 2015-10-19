import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }

    public void push(int item) {
        if (min_stack.empty() || item < min_stack.peek()) 
            min_stack.push(item);
        stack.push(item);
    }

    public int pop() {
        int ret = stack.pop();
        if (!min_stack.empty() && ret == min_stack.peek())
            min_stack.pop();
        return ret;
    }

    public int min() {
        return min_stack.peek();
    }
}

public class c3p2 {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(7);
        ms.push(3);
        ms.push(0);
        System.out.println(ms.min());
        ms.pop();
        ms.pop();
        System.out.println(ms.min());        
    }
}