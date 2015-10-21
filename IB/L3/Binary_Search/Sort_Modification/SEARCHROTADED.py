class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return an integer
    def helper(self, arr, begin, end, n):
        if (end < begin):
            return -1
        mid = (begin+end)/2
        if arr[mid] == n:
            return mid
        rs = arr[mid+1] < arr[end]
        ls = arr[begin] < arr[mid-1]
        if rs: # right is sorted
            if arr[mid+1] <= n and n <= arr[end]:
                return self.helper(arr, mid+1, end, n)
            else:
                return self.helper(arr, begin, mid-1, n)
        elif ls: # left is sorted
            if arr[begin] <= n and n <= arr[mid-1]:
                return self.helper(arr, begin, mid-1, n)
            else:
                return self.helper(arr, mid+1, end, n)
        else:
            if arr[mid] != arr[end]:
                return self.helper(arr, mid+1, end, n)
            else:
                res = self.helper(arr, begin, mid-1, n)
                if res == -1:
                    return self.helper(arr, mid+1, end, n)
                else:
                    return res
    
    def search(self, A, B):
        return self.helper(A, 0, len(A)-1, B)
        
