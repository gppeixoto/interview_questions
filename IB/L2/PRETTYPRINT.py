import copy

def printHelper(n):
    if n == 1:
	return [[1]]
    if n == 2:
        return [[2,2,2], [2,1,2], [2,2,2]]
    else:
        inner = printHelper(n-1)
        res = []
        outer = [n]*(2*n-1)
        res.append(outer)
        for circle in inner:
            new = circle[:]
            new.insert(0, n)
            new.insert(-1, n)
            res.append(new)
        res.append(outer)
        return res
