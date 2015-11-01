// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their 
// nodes contain a single digit. Add the two numbers and return it as a linked list
public class ADDNUM {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode node;
        ListNode prev = null;
        ListNode first = null;
        int carry = 0;
        int sum = 0;
        
        while (A != null || B != null || carry != 0) {
            
            node = new ListNode(0);
            sum = carry;
            
            if (first == null)
                first = node;
                
            if (prev != null)
                prev.next = node;
            
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
                
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            
            node.val = sum % 10;
            
            sum /= 10;
            carry = sum;
            prev = node;
        }
        
        return first;
        
    }
}