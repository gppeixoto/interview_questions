"""
Given a string s, partition s such that 
every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]

"""
class Solution:
    # @param A : string
    # @return a list of list of strings
    def partition(self, A):
        result = []
        self.partition_2(result, [], A, 0)
        return result

    def partition_2(self, result, cur, A, i):
        if i == len(A):
            result.append(list(cur))

        for j in range(i, len(A)):
            if self.isPalindrome(A[i:j+1]):
                cur.append(A[i:j+1])
                self.partition_2(result, cur, A, j+1)
                cur.pop()

    def isPalindrome(self, A):
        return list(A) == list(reversed(A))