"""
Given a binary tree, return the zigzag level order traversal 
of its nodes’ values. (ie, from left to right, then right to 
left for the next level and alternate between).
"""
def traverse(root, level, levels):
    if not root:
        return
    if len(levels) == level:
        levels.append([])
    levels[level].append(root.val)
    traverse(root.left, level+1, levels)
    traverse(root.right, level+1, levels)

def zigzagLevelOrder(root):
    if not root:
        return []
    
    levels = []
    traverse(root, 0, levels)
    for i in xrange(len(levels)):
        if i%2 != 0:
            levels[i] = levels[i][::-1]
    return levels