/*
Given K sorted (non decreasing) linked lists, return a
sorted linked list which is the union of all K lists 
(with repeated elements).

e.g.:
1 -> 1 -> 2
1 -> 3 -> 6
7 -> 8

return: 1->1->1->2->3->6->7->8
*/
import java.util.*;

class ListComparator implements Comparator<LinkedList<Integer>> {
    @Override
    public int compare(LinkedList<Integer> p, LinkedList<Integer> q) {
        int p_head_val = p.peekFirst();
        int q_head_val = q.peekFirst();
        return (p_head_val < q_head_val) ? -1 : 
                    ((p_head_val == q_head_val) ? 0 : 1);
    }
}

public class KSORTEDLISTS {
    static ArrayList<Integer> unionLists(ArrayList<LinkedList<Integer>> lists) {
        ListComparator comp = new ListComparator();
        PriorityQueue<LinkedList<Integer>> min_heap = 
            new PriorityQueue<LinkedList<Integer>>(comp);
        for (LinkedList<Integer> list : lists)
            min_heap.add(list);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (min_heap.size() > 1) {
            LinkedList<Integer> top = min_heap.poll();            
            while (!top.isEmpty() && top.peekFirst() <= min_heap.peek().peekFirst()) {
                int toAppend = top.removeFirst();
                ret.add(toAppend);
            }
            if (!top.isEmpty()) min_heap.add(top);
        }
        LinkedList<Integer> last = min_heap.poll();
        while (!last.isEmpty()) {
            ret.add(last.removeFirst());
        }
        return ret;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        LinkedList<Integer> m = new LinkedList<Integer>();
        LinkedList<Integer> n = new LinkedList<Integer>();
        l.addLast(1); l.addLast(1); l.addLast(2);
        m.addLast(1); m.addLast(3); m.addLast(6);
        n.addLast(7); n.addLast(8);
        ArrayList<LinkedList<Integer>> in = new ArrayList<LinkedList<Integer>>();
        in.add(l); in.add(m); in.add(n);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret = unionLists(in);
        for (Integer num : ret) System.out.println(num);
    }
}