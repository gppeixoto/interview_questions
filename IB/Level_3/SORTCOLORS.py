class Solution:
    # @param A : list of integers
    # @return A after the sort
    def sortColors(self, A):
        arr = A
        zero = []
        one = []
        two = []
        res = []
        for value in arr:
            if value == 0: zero.append(value)
            elif value == 1: one.append(value)
            else: two.append(value)
        for z in zero:
            res.append(z)
        for o in one:
            res.append(o)
        for t in two:
            res.append(t)
        return res