class Solution:
    # @param A : string
    # @return an integer
    def lengthOfLongestSubstring(self, A):
        hmap = {}
        max_len = 0
        st = 0
        for i, c in enumerate(A):
            if c in hmap and st <= hmap[c]:
                st = hmap[c] + 1
            else:
                max_len = max(max_len, i - st + 1)
            hmap[c] = i
        return max_len