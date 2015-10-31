from math import sqrt

class Solution:
    # @param A : integer
    # @return a list of integers
    
    def sieve(self, nb):
        mask = [1]*(nb)
        mask[0] = 0; mask[1] = 0
        table = dict()
        for i in xrange(int(sqrt(nb))+1):
            if mask[i]:
                for j in xrange(i*i, nb, i):
                    mask[j] = 0
        return mask
    
    def sum_prime(self, x):
        primes = self.sieve(x)
        res = ()
        for p in xrange(len(primes)):
            if primes[p] and primes[x-p]:
                res = (p, x-p)
                break
        return res
        
    def primesum(self, A):
        return self.sum_prime(A)