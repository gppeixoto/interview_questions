/**
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Example :
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 * 
**/

/*
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a.size() == 1)
            return a.get(0);
        
        PriorityQueue<Integer> pq =  new PriorityQueue<Integer>();
        for (ListNode head : a) {
            ListNode aux = head;
            while (aux != null) {
                pq.add(aux.val);
                aux = aux.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(-1);
        dummy.next = head;
        while (pq.size() != 0) {
            int n = pq.remove();
            head.val = n;
            if (pq.size() == 0) break;
            head.next = new ListNode(-1);
            head = head.next;
        }
        return dummy.next;
    }
}
