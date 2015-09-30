import java.util.Stack;

/*
    solved, altough non optimal version
    must code the optimal one still (or at least cleaner)

    time complexity:
    2n+2(n-1)+2(n-2)+...+2 = O(2n^2) = O(n^2)
*/
public class c3p6 {
    public static Stack<Integer> sort_stack(Stack<Integer> to_sort) {
        Stack<Integer> aux = new Stack<Integer>();
        int min = Integer.MAX_VALUE;
        int sz = 0;
        int i = 0;
        while (!to_sort.empty()) {
            while (!to_sort.empty()) {
                int top = to_sort.pop();
                if (top < min) min = top;
                aux.push(top);
                sz++;
            }
            while (sz > i) {
                if (aux.peek() != min) {
                    to_sort.push(aux.pop());
                    sz--;
                } else {
                    aux.pop();
                    sz--;
                }
            }
            aux.push(min);
            sz++;
            i++;
            min = Integer.MAX_VALUE;
        }
        return aux;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(4); s.push(2); s.push(1); s.push(3);
        Stack<Integer> p = sort_stack(s);
        while (!p.empty()) System.out.println(p.pop());
    }
}