"""
Given a list of integers, return the arrangement
in which it forms the biggest possible number

e.g.: (2, 8 , 2 ,4): "8422"
"""
class Solution:
    # @param A : tuple of integers
    # @return a strings
        
    def f(self, i, j):
        left = i+j
        right = j+i
        if left < right:
            return 1
        elif left == right:
            return 0
        else:
            return -1
        
    def sort(self, A):
        A.sort(cmp=self.f)
        return A
    
    def largestNumber(self, A):
        A = map(lambda x: str(x), A)
        A = self.sort(A)
        if A[0] == '0':
            return '0'
        return ''.join(_ for _ in A)
