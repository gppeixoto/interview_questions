class BitInteger:
    INTEGER_SIZE = 32
    
    def __init__(self, val=0):
        self.val = val
 
    def fetch(self, p):
        return 1 if (self.val & (1 << p)) != 0 else 0
    
def find_missing(nb_list, col):
    if col >= BitInteger.INTEGER_SIZE:
        return 0

    zeros = []
    ones = []

    for bi in nb_list:
        if bi.fetch(col) == 0:
            zeros.append(bi)
        else:
            ones.append(bi)

    if len(zeros) <= len(ones):
        v = find_missing(zeros, col+1)
        return ((v << 1) | 0)
    else:
        v = find_missing(ones, col+1)
        return ((v << 1) | 1)

from random import choice, shuffle
removed = choice(range(1000))
bi_list = [BitInteger(i) for i in xrange(1000) if i != removed]
shuffle(bi_list)
print "%d was removed: %s" % (removed, find_missing(bi_list, 0)==removed)
