/**
* Given two binary trees, write a function to check if they are equal or not.
* Two binary trees are considered equal if they are structurally 
* identical and the nodes have the same value.
*/
public class SAMETREE {
    public int same(TreeNode a, TreeNode b) {
        if (a == null && b == null) return 1;
        if ((a==null && b!=null) || (a!=null && b==null)) return 0;
        int l = same(a.left, b.left);
        if (l == 0) return 0;
        int r = same(a.right, b.right);
        if (r == 0) return 0;
        if (a.val != b.val) return 0;
        return 1;
    }
    
    public int isSameTree(TreeNode a, TreeNode b) {
        return same(a,b);
    }
}