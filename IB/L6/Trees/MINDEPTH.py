"""
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along 
the shortest path from the root node down to the nearest leaf node.

NOTE : The path has to end on a leaf node. 
"""
def foo(root):
    if not root:
        return (1<<31)-1
    if not root.left and not root.right:
        return 1
    return min(
            foo(root.left),
            foo(root.right)
        ) + 1


def minDepth( A):
    return foo(A)