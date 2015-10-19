from math import sqrt

def sieve(max):
    flags = [True for i in xrange(max+1)]
    cnt = 0
    flags[0] = False; flags[1] = False
   
    prime = 2
    while prime <= sqrt(max):
        flags = cross_off(flags, prime)
        prime = get_next(flags, prime)
        if prime > len(flags):
            break
    primes_list = [j for i,j in zip(flags, xrange(max+1)) if i]
    return primes_list

def cross_off(flags, prime):
    #for (int i=prime*prime; i < flags.length; i += prime)
    
    for i in xrange(prime*prime, len(flags), prime):
        flags[i] = False
    return flags

def get_next(flags, prime):
    for i in xrange(prime+1, len(flags)):
        if flags[i]:
            return i
