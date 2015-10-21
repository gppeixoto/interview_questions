class Solution:
    # @param A : list of list of integers
    # @param B : integer
    # @return an integer
    def searchMatrix(self, A, B):
        mat = A
        n = B
        row = 0
        col = len(mat[0])-1
        
        while row < len(A) and col >= 0:
            num = mat[row][col]
            if num == n:
                return 1
            elif num < n:
                row += 1
            else:
                col -= 1
        return 0