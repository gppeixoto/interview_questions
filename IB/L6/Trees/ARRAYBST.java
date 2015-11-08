/**
* Given an array where elements are sorted 
* in ascending order, convert it to a height balanced BST.
*/
public class ARRAYBST {
    public TreeNode bst(final List<Integer> a, int begin, int end) {
        if (end < begin) return null;
        int mid = (begin+end)/2;
        TreeNode root = new TreeNode(a.get(mid));
        root.left = bst(a, begin, mid-1);
        root.right = bst(a, mid+1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a.size() == 0) return null;
        return bst(a, 0, a.size()-1);
    }
}