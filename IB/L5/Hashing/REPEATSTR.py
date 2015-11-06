class Solution:
    # @param A : tuple of strings
    # @return a list of list of integers
    def anagrams(self, A):
        hmap = {}
        for i, seq in enumerate(A):
            key = sorted(seq)
            print key
            if key not in hmap:
                hmap[key] = []    
            hmap[key].append(i)
        return sorted(hmap.values())