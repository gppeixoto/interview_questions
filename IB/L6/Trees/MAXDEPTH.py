"""
Given a binary tree, find its maximum depth.
"""
class Solution:
    # @param A : root node of tree
    # @return an integer
    def foo(self, root):
        if not root:
            return -1
        return max(self.foo(root.left), self.foo(root.right))+1

    def maxDepth(self, A):
        return self.foo(A)