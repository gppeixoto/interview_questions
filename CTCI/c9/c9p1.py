import sys

def count_ways(n):
    l = [0]*n
    l[0] = 1
    l[1] = 2
    l[2] = 4
    for i in xrange(3, n):
        l[i] = l[i-1] + l[i-2] + l[i-3]
    return l[n-1]

if __name__ == "__main__":
    for i in sys.argv[1:]:
        res = count_ways(int(i))
        int_max = (1 << 31) - 1
        print res if res < int_max else "%d > Integer.MAX_VALUE" % (res)
