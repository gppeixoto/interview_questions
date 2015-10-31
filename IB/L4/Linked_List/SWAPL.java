// Given a linked list, swap every two adjacent nodes and return its head.
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// Your algorithm should use only constant space. 
// You may not modify the values in the list, only nodes itself can be changed.
public class SWAPL {
    static ListNode swap(ListNode n1, ListNode n2) {
        n1.next = n2.next;
        n2.next = n1;
        return n2;
    }

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null)
            return a;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = a;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            cur.next = swap(cur.next, cur.next.next);
            cur = cur.next.next;
        }
        return dummy.next;
    }    
}
