def addBinary(A, B):
    if not A:
        return B
    if not B:
        return A
    
    if len(A) < len(B):
        while len(A) < len(B): A = "0" + A

    if len(B) < len(A):
        while len(B) < len(A): B = "0" + B
    smaller = A
    bigger = B

    carry = '0'
    res = ""
    i = len(smaller)-1
    while i >= 0:
        if smaller[i]=='0' and bigger[i]=='0':
            res = carry + res
            carry = '0'
        elif smaller[i]=='1' and bigger[i]=='1':
            res = carry + res
            carry = '1'
        elif carry == '1':
            res = '0' + res
            carry = '1'
        else:
            res = '1' + res
            carry = '0'
        i -= 1
    if carry == '1':
        res = '1' + res
    return res
