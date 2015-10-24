def break_tie(max_set):
    by_length = dict()
    for set_ in max_set:
        res = by_length.get(len(set_), [])
        res.append(set_)
        by_length[len(set_)] = res
    max_len = max(by_length)
    if len(by_length[max_len]) == 1:
        return by_length[max_len][0]
    else:
        # break tie by minimum starting index
        min = (1 << 31)-1 # Integer.MAX_VALUE
        ret_set = []
        for set_ in by_length[max_len]:
            if set_[0] < min:
                min = set_[0]
                ret_set = set_
        return ret_set

def maxset(A):
    arr = A
    sets = dict()
    tmp = []
    for val in A:
        if val >= 0:
            tmp.append(val)
        else:
            key = sum(tmp)
            if key >= 0:
                list_ = sets.get(key, [])
                list_.append(tmp)
                sets[key] = list_
                tmp = []

# last iteration might have left some out
    key = sum(tmp)
    if key > 0:
        list_ = sets.get(key, [])
        list_.append(tmp)
        sets[key] = list_
    if not sets:
        return []
    max_set = max(sets) # returns biggest key
    if max_set == 0:
        if not any(sets[max_set]):
            return []
        else:
            return sets[max_set][0]
    if len(sets[max_set]) == 1:
        return sets[max_set][0]
    else:
        return break_tie(sets[max_set])
