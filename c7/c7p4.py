# ask if it is allowed to use
# the -1 value and if it is allowed
# to use check operations (<, >, etc)
import sys

def negate(n):
    d = 1 if n < 0 else -1
    neg = 0
    while n != 0:
        neg += d
        n += d
    return neg

def sub(a, b):
    return a + negate(b)

def abs_(n):
    return n if n >= 0 else negate(n)

def eq_sign(a, b):
    return (a < 0 and b < 0) or (a >= 0 and b >= 0)

def mult(a, b):
    res = 0
    b = b if b >= 0 else negate(b)
    eq = eq_sign(a, b)
    for i in xrange(b):
        res += a
    if (eq and res < 0) or (not eq and res > 0):
        res = negate(res)
    return res

def div(a, b):
    if b == 0:
        print "div_zero_ERROR"
        return -((1<<31) - 1) # used - 
    else:
        res = 0
        x = abs_(a); y = abs_(b)
        while x >= y:
            x -= y
            res += 1
        eq = eq_sign(a, b)
        res = abs_(res) if eq else negate(abs_(res)) 
        return res
