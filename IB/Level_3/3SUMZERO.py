def threeSum(A):
    if A == []:
        return []
    a = A
    a = sorted(a)
    i = 0
    j = i+1
    k = len(a)-1
    res = []
    while a[i] <= 0 and i < len(a)-2:
        eq = (i == j) and (j == k)
        sum3 = a[i] + a[j] + a[k]
        if sum3 == 0 and not eq:
            tup = (a[i],a[j],a[k])
            if tup not in res:
                res.append(tup)
            j += 1
        elif sum3 < 0:
            j += 1
        elif sum3 > 0:
            k -= 1
        if k == j or k == 0 or j == len(a):
            i += 1
            j = i + 1
            k = len(a) - 1
    return res