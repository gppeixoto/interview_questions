import java.util.*;

public class EVALEXP {
    static boolean isNum(String s) {
        if (s.length() == 1 && s.charAt(0) == '-') return false;
        int j=0;
        if (s.charAt(0) == '-') j = 1;
        for (int i=j; i < s.length(); ++i) {
            char c = s.charAt(i);
            int val = c - '0';
            if (val < 0 || val > 9) return false;
        }
        return true;
    }
    
    static int parse(String s) {
        return Integer.parseInt(s);
    }
    
    static int evalRPN(ArrayList<String> a) {
        if (a.size() == 1) {
            return parse(a.get(0));
        }
        Stack<Integer> st = new Stack<Integer>();
        for (String op : a) {
            System.out.println("stack: " + st.toString());
            if (isNum(op)) st.push(parse(op));
            else {
                int snd = st.pop();
                int fst = st.pop();
                if (op.equals("+")) st.push(fst+snd);
                else if (op.equals("*")) st.push(fst*snd);
                else if (op.equals("/")) st.push(fst/snd);
                else st.push(fst-snd);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        ArrayList<String> exp = new ArrayList<String>();
        for (String arg : args) {
            exp.add(arg);
        }
        System.out.println("res: " + evalRPN(exp));
    }
}