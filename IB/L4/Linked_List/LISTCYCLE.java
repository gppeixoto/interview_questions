
// Given a linked list, return the node where the cycle begins.
// If there is no cycle, return null.

public class LISTCYCLE {
    public ListNode detectCycle(ListNode a) {
        if (a == null || a.next == null)
            return null;
        
        ListNode p1 = a, p2 = a;
        boolean cycle = false, fst = true;
        while (p1 != null && p2 != null) {
            if (p1 == p2 && !fst){
                cycle = true;
                break;
            }
            if (p2.next == null) break;
            if (fst) fst = false;
            p1 = p1.next;
            p2 = p2.next.next;

        }
        if (cycle) {
            p1 = a;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return (cycle) ? p1 : null;
    }
}
