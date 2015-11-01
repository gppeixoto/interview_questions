import copy

def helper(A, cur, i):
    if i == len(A):
        return cur
    
    new = copy.copy(cur)
    for elem in cur:
        new.append(elem+[A[i]])
    return helper(A, new, i+1)

def subsets(A):
    return sorted(helper(sorted(A), [[]], 0))