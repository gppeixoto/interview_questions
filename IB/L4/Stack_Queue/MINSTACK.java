class MINSTACK {
    Stack<Integer> min, st;
    
    public MINSTACK() {
        min = new Stack<Integer>();
        st = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if (min.empty() || x < min.peek()) min.push(x);
    }

    public void pop() {
        if (st.empty()) return;
        int top = st.pop();
        if (top == min.peek()) min.pop();
    }

    public int top() {
        if (st.empty()) return -1;
        return st.peek();
    }

    public int getMin() {
        if (st.empty()) return -1;
        return min.peek();
    }
}