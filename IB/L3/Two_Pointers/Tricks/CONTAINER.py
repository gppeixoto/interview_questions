class Solution:
    # @param A : list of integers
    # @return an integer
    def maxArea(self, A):
        i = len(A)-1
        j = 0
        area = -1
        while i >= 0 and j < len(A):
            res = abs(i-j)*min(A[i], A[j])
            if res > area:
                area = res
            if A[j] < A[i]:
                j += 1
            else:
                i -= 1
        return area
