"""
Count the number of trailing zeros
in the factorial of a number.
"""
class Solution:
    # @param A : integer
    # @return an integer
    def trailingZeroes(self, A):
        n = A
        cnt = 0
        j = 5
        while n/j > 0:
            cnt += n/j
            j *= 5
        return cnt if n != 5 else 1
