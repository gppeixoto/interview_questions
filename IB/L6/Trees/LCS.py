"""
Given two strings s1 and s2, find the 
longest common substring between them.
"""
def memoize(p, q):
    n = len(p)
    m = len(q)
    memo = [[0 for i in range(m+1)] for j in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, m+1):
            memo[i][j] = max(
                    memo[i-1][j],
                    memo[i][j-1],
                    memo[i-1][j-1] + (1 if p[i-1]==q[j-1] else -(1<<31))
                )
    return memo

def backtrack(p, q, i, j, memo):
    if i == 0 or j == 0:
        return ''
    elif p[i-1] == q[j-1]:
        return backtrack(p, q, i-1, j-1, memo) + p[i-1]
    else:
        if memo[i][j-1] > memo[i-1][j]:
            return backtrack(p, q, i, j-1, memo)
        else:
            return backtrack(p, q, i-1, j, memo)

def LCS(p, q):
    n = len(p)
    m = len(q)
    memo = memoize(p, q)
    return backtrack(p, q, n, m, memo)