// Reverse a linked list from position m to n. Do it in-place and in one-pass.
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// return 1->4->3->2->5->NULL.
public class REVERSELIST {
    public ListNode reverseBetween(ListNode a, int m, int n) {
        if (a == null || a.next == null)
            return a;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = a;
        ListNode prev = dummy;
        for (int i=0; i < m-1; ++i) prev = prev.next;
            ListNode point = prev;
        ListNode cur = prev.next; ListNode next;
        int i=0;
        while (cur != null && i <= (n-m)) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        point.next.next = cur;
        point.next = prev;
        return dummy.next;
    }
}
