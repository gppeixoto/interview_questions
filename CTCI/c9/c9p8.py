def make_change(amount, denoms, index, map_):
    if map_[amount][index] > 0:
        return map_[amount][index]
    if index >= len(denoms)-1:
        return 1
    denomAmount = denoms[index]
    i = 0
    ways = 0
    while i*denomAmount <= amount:
        remaining = amount-i*denomAmount
        ways += make_change(remaining, denoms, index+1, map_) 
        i += 1
    map_[amount][index] = ways
    return ways

def changes(n):
    denoms = [25, 10, 5, 1]
    map_ = [[0]*len(denoms)]*(n+1) #int[n+1][denoms.length]
    ways = make_change(n, denoms, 0, map_)
    return (ways, map_)
