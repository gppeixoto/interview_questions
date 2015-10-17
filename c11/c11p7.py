from random import randint

def lis_helper(nbs, res, cur):
    if cur == 0:
        res.append([nbs[0]])
        return lis_helper(nbs, res, cur+1)
    if cur == len(nbs):
        return res
    nb = nbs[cur]
    max_ = []
    for seq in res:
        last = seq[-1]
        if nb[1] > last[1] and len(seq)+1 > len(max_):
            seq_ = seq[:]
            seq_.append(nb)
            max_ = seq_
    if len(max_) == 0:
        max_ = [nb]
    res.append(max_)
    return lis_helper(nbs, res, cur+1)

def lis(nbs):
    res = lis_helper(nbs, [], 0)
    max_ = []
    for seq in res:
        if len(seq) > len(max_):
            max_ = seq
    return max_

def largest_tower(ps):
    ps = sorted(ps, key=lambda x:x[0])
    res = lis(ps)
    return res

if __name__ == "__main__":
    circus = [(randint(150,180),randint(50,90)) for i in xrange(20)]
    tw = largest_tower(circus)
    print "circus: %s" % str(circus)
    print "largest tower: %s" % str(tw)
