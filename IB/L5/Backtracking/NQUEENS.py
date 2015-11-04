import copy

class Solution:
# @param A : integer
# @return a list of list of strings
    def is_possible(self, brd, row, col):
        for row2 in xrange(0, row):
            col2 = brd[row2]
            if (col == col2):
                return False
            if abs(row-row2) == abs(col-col2):
                return False
        return True

    def helper(self, A, res, brd, i):
        if i == A:
            res.append(copy.copy(brd))
        for col in xrange(0, A):
            if self.is_possible(brd, i, col):
                brd[i] = col
                self.helper(A, res, brd, i+1)

    def int_str(self, n, A):
        return '.'*(n) + 'Q' + '.'*(A-n-1)

    def nqueens(self, A):
        brd = [0 for i in xrange(A)]
        res = []
        self.helper(A, res, brd, 0)
        return res

    def solveNQueens(self, A):
        res = self.nqueens(A)
        ret = []
        for i in res:
            sol = []
            for j in i:
                sol.append(self.int_str(j, A))
            ret.append(sol)
        return ret