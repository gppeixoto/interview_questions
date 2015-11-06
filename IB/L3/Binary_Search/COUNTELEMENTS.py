class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return an integer
    def findCount(self, A, B):
        arr = A; n = B
        lo = 0
        hi = len(arr)-1
        cnt = 0
        while lo <= hi:
            mid = (lo+hi)/2
            if arr[mid] == n:
                #search repeated left and right
                aux = mid
                while aux < len(arr) and arr[aux] == n:
                    cnt += 1
                    aux += 1
                aux = mid-1
                while aux >= 0 and arr[aux] == n:
                    cnt += 1
                    aux -= 1
                break
            elif arr[mid] < n:
                lo = mid + 1
            else:
                hi = mid - 1
        return cnt