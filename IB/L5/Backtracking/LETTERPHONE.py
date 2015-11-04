def helper(A, i, cur, map_):
    if (i == len(A)):
        return cur
    
    new = []
    for letter in map_[int(A[i])]:
        for comb in cur:
            new.append(comb + letter)
    return helper(A, i+1, new, map_)

def letterCombinations(A):
    if A == "":
        return A
        
    map_ = {1: {"1"},
            2: {"a", "b", "c"},
            3: {"d", "e", "f"},
            4: {"g", "h", "i"},
            5: {"j", "k", "l"},
            6: {"m", "n", "o"},
            7: {"p", "q", "r", "s"},
            8: {"t", "u", "v"},
            9: {"w", "x", "y", "z"},
            0: {"0"}
        }
    cur = [""]
    ret = helper(A, 0, cur, map_)
    ret = sorted(ret)
    return ret

def substrings(s, i):
    if len(s) <= 1:
        return s

    for k in xrange()