class Solution:
    # @param A : unsigned integer
    # @return an unsigned integer
    def reverse(self, A):
        for i in xrange(16):
            left = 1 if (A&(1 << (31-i))) != 0 else 0
            right = 1 if (A&(1 << i)) != 0 else 0
            flip = left ^ right
            A ^= (flip << (31-i))
            A ^= (flip << i)
        return A
