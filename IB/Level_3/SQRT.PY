class Solution:
    # @param A : integer
    # @return an integer
    def helper(self, begin, end, n):
        if end < begin:
            return end
        mid = (begin+end)/2
        sq = mid*mid
        if sq == n:
            return mid
        elif sq < n:
            return self.helper(mid+1, end, n)
        else:
            return self.helper(begin, mid-1, n)

    def sqrt(self, A):
        return self.helper(0, A, A)
