/*
 * Given a singly linked list, determine if its a palindrome. 
 * Return 1 or 0 denoting if its a palindrome or not, respectively.
*/
public class LPALIN {
    
    public int lPalin(ListNode a) {
        int n=0;
        ListNode head = a;
        while (head != null) {
            head = head.next;
            ++n;
        }
        head = a;
        for (int i=0; i < (n/2); ++i){
            head = head.next;
        }
        if (n % 2 != 0)
            head = head.next;
        Stack<Integer> s = new Stack<Integer>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        head = a;
        while (!s.empty()) {
            int val = s.pop();
            if (val != head.val)
                return 0;
            head = head.next;
        }
        return 1;
    }
}