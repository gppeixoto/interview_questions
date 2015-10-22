class Solution:
    # @param A : integer
    # @param B : integer
    # @return an integer
    def gcd(self, A, B):
        m = A
        n = B
        i = min(m,n)
        if m == 0:
            return n
        elif n == 0:
            return m
            
        while m > 0 and n > 0:
            if (n % i == 0) and (m % i == 0):
                return i
            else:
                if m > n:
                    m -= n
                else:
                    n -= m
            i = min(m,n)
        return 1
