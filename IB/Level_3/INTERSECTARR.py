def intersect(A, B):
    res = []
    i = 0
    j = 0
    while i < len(A) and j < len(B):
        if A[i] == B[j]:
            res.append(A[i])
            i += 1
            j += 1
        elif A[i] < B[j]:
            i += 1
        else:
            j += 1
    return res
