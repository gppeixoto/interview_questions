def sgn(n):
    return -1 if n < 0 else +1

def foo(n, m):
    if n == 0:
        return '0'
    occurred = {}
    frac_part = []
    i = 0
    j = -1
    rep = False
    neg = True if sgn(n) != sgn(m) else False
    n = abs(n)
    m = abs(m)
    rem = n%m
    int_part = int(n/m)
    while rem != 0 and not rep:
        if rem not in occurred:
            occurred[rem] = i
            rem *= 10
            frac_part.append(str(rem/m))
            rem %= m
        else:
            rep = True
            j = occurred[rem]
        i += 1
    ret = str(int_part) if not neg else '-'+str(int_part)
    if frac_part and not rep:
        ret += '.'+''.join(frac_part)
    elif frac_part and rep:
        ret += '.'+''.join(frac_part[:j])
        ret += '('
        ret += ''.join(frac_part[j:])
        ret += ')'
    return ret
    
def fractionToDecimal(numerator, denominator):
    return foo(numerator, denominator)