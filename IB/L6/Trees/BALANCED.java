//Given a binary tree, 
//determine if it is height-balanced.
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution 1: inneficient, many
//visits to same nodes
public class Solution {
	static int get_height(TreeNode root) {
	if (root == null)
		return -1;
	return Math.max(
            get_height(root.left),
            get_height(root.right)
        ) + 1;
    }
    public int isBalanced(TreeNode a) {
    	if (a == null)
    		return 1;
    	int h1 = get_height(a.left);
    	int h2 = get_height(a.right);
    	if (Math.abs(h1-h2) > 1) 
    	    return 0;
    	return isBalanced(a.left) & isBalanced(a.right);
    }
}

//Solution 2: better
//Uses global variable while checking the
//height of the tree

//public class Solution {
//        int balanced = 1;
//	public int isBalanced(TreeNode A) {
//	    balanced(A);
//	    return balanced;
//	}
//	
//	public int balanced(TreeNode A) {
//	    if (A == null)
//	        return 0;
//	        
//	    int heightLeft = 1 + balanced(A.left);
//	    int heightRight = 1 + balanced(A.right);
//	    if (Math.abs(heightLeft - heightRight) > 1)
//	        balanced = 0;
//	    return Math.max(heightLeft, heightRight);
//	}
//}

//Solution 3: C++ code
//best solution

//class Solution {
//public:
//    bool isBalanced(TreeNode *root) {
//        if (root == NULL) return true;
//        return isBalancedWithDepth(root).second;
//    }
//
//    pair<int, bool> isBalancedWithDepth(TreeNode *root) {
//        if (root == NULL)
//              return make_pair(0, true);
//        pair<int, bool> left = isBalancedWithDepth(root->left);
//        pair<int, bool> right = isBalancedWithDepth(root->right);
//        int depth = max(right.first, left.first) + 1;
//        // The subtree is balanced if right subtree is balanced, left subtree is balanced 
//        // and the depth difference is less than 1. 
//        bool isbalanced = right.second && left.second && (abs(right.first - left.first) < 2);
//        return make_pair(depth, isbalanced);
//    }
//};
