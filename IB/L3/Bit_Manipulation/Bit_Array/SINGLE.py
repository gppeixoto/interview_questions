class Solution:
    # @param A : tuple of integers
    # @return an integer
    def singleNumber(self, A):
        num = 0
        for nb in A:
            num ^= nb
        return num