class Solution:
# @param A : list of integers
# @param B : integer
# @return a list of integers
    def dNums(self, A, B):
        k = B
        if not A:
            return []
        if k > len(A):
            k = len(A)
        
        occs = {}
        sum_ = 0
        res = []
        for i in xrange(k):
            occs[A[i]] = occs.get(A[i], 0) + 1
            if occs[A[i]] == 1:
                sum_ += 1
        res.append(sum_)
        for i in xrange(k, len(A)):
            occs[A[i-k]] -= 1
            if occs[A[i-k]] == 0:
                sum_ -= 1
            occs[A[i]] = occs.get(A[i], 0) + 1
            if occs[A[i]] == 1:
                sum_ += 1
            res.append(sum_)
        return res