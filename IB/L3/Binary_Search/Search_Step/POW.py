class Solution:
    # @param x : integer
    # @param n : integer
    # @param d : integer
    # @return an integer
    def exp(self, x, n, p):
        if x == 0 and n == 0:
            return 0
        if n < 0:
            x = 1./x
            n = -n
        if n == 0:
            return 1
        y = 1
        while n > 1:
            if n%2 == 0:
                x = (x*x)%p
                n /= 2
            else:
                y = x*y
                x = (x*x)%p
                n = (n-1)/2
        return (x*y)%p

    def pow(self, x, n, d):
        return self.exp(x,n,d)

### better solution:
"""
class Solution:
    # @param A : integer
    # @param B : integer
    # @param C : integer
    # @return an integer
    def pow(self, A, B, C):
        result = 1
        base = A % C
        while B > 0:
            if B % 2 == 1:
                result = (result*base) % C
            B = B >> 1
            base = (base*base)%C
        return result%C
"""