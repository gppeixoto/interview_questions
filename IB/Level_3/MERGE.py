class Solution:
# @param A : list of integers
# @param B : list of integers
# @return A modified after the merge
    def merge(self, A, B):
        i = 0
        j = 0
        res = []
        while i < len(A) and j < len(B):
            if A[i] <= B[j]:
                res.append(A[i])
                i += 1
            else:
                res.append(B[j])
                j += 1
        while i < len(A):
            res.append(A[i])
            i += 1
        while j < len(B):
            res.append(B[j])
            j += 1
        return res