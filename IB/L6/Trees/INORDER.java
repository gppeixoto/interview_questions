/**
 * Given a binary tree, return the 
 * inorder traversal of its nodes’ values.
 * Using recursion is not allowed.
 */
import java.util.*;
public class INORDER {

    static void inorder(TreeNode root, ArrayList<Integer> res){
        Stack<ListNode> s = new Stack<ListNode>();
        TreeNode cur = a;
        while (true) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                TreeNode n = s.pop();
                res.add(n.val);
                cur = n.right;
            }
            if (cur == null && s.empty())
                break;
        }
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        inorder(a, l);
        return l;
    }

    //Iterative and stack-less traversal
    static void MorrisTraversal(TreeNode a, ArrayList<Integer> l) {
        if (root == null) return;
        TreeNode cur = root, prev = null;
        while (cur != null) {
            if (cur.left == null) {
                a.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    a.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
}

