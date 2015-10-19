import java.util.Stack;
import java.util.Vector;

class StackSet {
    Vector<Stack<Integer>> set;
    int curr, cap;

    public StackSet(int c) {
        set = new Vector<Stack<Integer>>();
        set.add(new Stack<Integer>()); //adding first stack
        cap = c;
        curr = 0;
    }

    public void push(int item) {
        if (set.elementAt(curr).size() == cap) {
            Stack<Integer> s = new Stack<Integer>();
            set.add(s);
            curr++;
        }
        set.elementAt(curr).push(item);
    }

    public int pop() {
        if (set.elementAt(curr).size() == 0) {
            set.remove(curr);
            curr--;
        }
        return set.elementAt(curr).pop();
    }

    public int peek() {return set.elementAt(curr).peek();}
}

public class c3p3 {
    public static void main(String[] args) {
        StackSet s = new StackSet(5);
        for (int i=0; i<15; ++i) s.push(15-i);
        for (int i=0; i<15; ++i) {
            System.out.println(s.pop());
        }
        System.out.println(s.set.size());
    }
}