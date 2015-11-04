"""
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"
"""
class Solution:
    # @param n : integer
    # @param k : integer
    # @return a strings
    def fact(self, n):
        if n > 12:
            return ((1<<31)-1)
        fat = 1
        
        for i in xrange(2, n+1):
            fat *= i
        return fat
    
    def helper(self, k, candidates):
        n = len(candidates)
        if n == 0:
            return ''
        if k > self.fact(n):
            return ''
        
        f = self.fact(n-1)
        pos = k/f
        k %= f
        ch = candidates[pos]
        candidates.pop(pos)
        return str(ch)+self.helper(k, candidates)
    
    def getPermutation(self, n, k):
        candidates = [i+1 for i in xrange(n)]
        return self.helper(k-1, candidates)
        
        
        