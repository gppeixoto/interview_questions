def find_bs(ll, begin, end):
    if end < begin or begin < 0 or end >= len(ll):
        return -1
    mid = (begin+end)/2
    if mid == ll[mid]:
        return mid
    left = True if mid < ll[mid] else False
    return find_bs(ll, begin, mid-1) if left\
            else find_bs(ll, mid+1, end)

def find(ll):
    return find_bs(ll, 0, len(ll)-1)

if __name__ == "__main__":
    ll = [-15, -10, -5, 0, 3, 4, 6, 10, 15]
    print find(ll)
