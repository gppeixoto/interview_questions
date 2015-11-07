//Given a binary tree and a sum, determine if the tree has a 
//root-to-leaf path such that adding up all the values 
//along the path equals the given sum.

public class PATH {
    static int pathsum(TreeNode a, int b, int cur_sum) {
        if (a == null)
            return 0; 
        int c = cur_sum + a.val;
        if (a.left == null && a.right == null) {
            if (c == b) return 1;
        }
        if (pathsum(a.left, b, c) == 1) return 1;
        else if (pathsum(a.right, b, c) == 1) return 1;
        return 0;
    }

    public int hasPathSum(TreeNode a, int b) {
        return pathsum(a, b, 0);
    }
}