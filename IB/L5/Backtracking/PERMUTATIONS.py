import copy

class Solution:
    # @param A : list of integers
    # @return a list of list of integers

    def insert(self, list_, item, i):
        cp_list = copy.copy(list_)
        cp_list.insert(i, item)
        return cp_list

    def helper(self, A, i, cur):
        if i == len(A):
            return cur
        
        num = A[i]
        len_seq = len(cur[0])
        new = []

        for seq in cur:
            for j in xrange(len_seq+1):
                n_seq = self.insert(seq, num, j)
                new.append(n_seq)

        return self.helper(A, i+1, new)
    
    def permute(self, A):
        return sorted(self.helper(A, 0, [[]]))
        
        
        