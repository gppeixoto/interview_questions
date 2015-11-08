/**
* Given a binary tree, invert the binary tree and return it. 
* Look at the example for more details.
*/
public class INVERT {
    static TreeNode inv (TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode tmp = root.right;
        root.right = inv(root.left);
        root.left = inv(tmp);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        return inv(root);
    }
}