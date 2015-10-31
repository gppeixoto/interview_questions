
// Given a linked list and a value x, partition it such 
// that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative 
// order of the nodes in each of the two partitions.
public class PARTITION {

    static ListNode partition(ListNode a, int b) {
        if (a == null) return a;
        
        ListNode dummy_left = new ListNode(-1);
        ListNode dummy_right = new ListNode(-1);
        
        ListNode l = null, r = null;
        
        while (a != null) {
            if (a.val < b) {
                if (l == null) {
                    dummy_left.next = new ListNode(a.val);
                    l = dummy_left.next;
                } else {
                    l.next = new ListNode(a.val);
                    l = l.next;
                }
            } else {
                if (r == null) {
                    dummy_right.next = new ListNode(a.val);
                    r = dummy_right.next;
                } else {
                    r.next = new ListNode(a.val);
                    r = r.next;
                }
            }
            a = a.next;
        }
        if (l == null) {
            return dummy_right.next;
        } else {
            l.next = dummy_right.next;
            return dummy_left.next;
        }
    }
    
}
