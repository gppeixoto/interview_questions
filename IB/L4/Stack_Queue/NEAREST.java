// Given an array, find the nearest smaller element G[i] 
// for every element A[i] in the array 
// such that the element has an index smaller than i.
import java.util.*;

public class NEAREST {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (Integer n : arr) {
            if (st.empty()) {
                ret.add(-1);
            } else {
                while (!st.empty() && st.peek() >= n){
                    st.pop();
                }
                ret.add( st.empty() ? -1 : st.peek() );
            }
            st.push(n);
        }
        return ret;
    }
}