def findFirst_naive(ss):
    i = 0
    n = len(ss)
    found = False
    while i < n-1 and not found:
        for j in xrange(i+1, n):
            if ss[i] == ss[j]:
                return ss[i]
                break
        i += 1
    return None

def findFirst_sort(ss):
    ss = sorted([char for char in ss])
    for i in xrange(len(ss)-1):
        if ss[i]==ss[i+1]:
            return ss[i]
    return None

def findFirst_map(ss):
    hmap = {}
    for i in ss:
        if i in hmap.keys():
            return i
        hmap[i] = 1
    return None