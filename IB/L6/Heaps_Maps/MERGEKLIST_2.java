/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> A) {
        TreeMap<Integer, ArrayList<ListNode>> map = new TreeMap<>();
        ListNode node;
        ArrayList<ListNode> list;
        int val;
        for (ListNode head : A) {
            node = head;
            while (node != null) {
                val = node.val;
                if (map.containsKey(val)) {
                    list = map.get(val);
                    list.add(node);
                } else {
                    list = new ArrayList<>();
                    list.add(node);
                    map.put(val, list);
                }
                node = node.next;
            }
        }
        ListNode head = null;
        node = null;
        for (Map.Entry<Integer, ArrayList<ListNode>> entry : map.entrySet()) {
            list = entry.getValue();
            for (ListNode n : list) {
                if (head == null)
                    head = n;
                if (node != null)
                    node.next = n;
                node = n;
            }
            
        }
        return head;
    }
}