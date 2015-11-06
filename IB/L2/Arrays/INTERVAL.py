# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
    def __str__(self):
        return "(%d,%d)" % (self.start, self.end)

def insert(intervals, new_interval):
    fst = min(new_interval.start, new_interval.end)
    snd = max(new_interval.start, new_interval.end)
    
    # empty intervals:
    if not intervals:
        return [Interval(fst, snd)]
    min_ = intervals[0].start
    max_ = intervals[-1].end
    if snd < min_: #before intervals
        intervals.insert(0, Interval(fst, snd))
        return intervals
    elif fst > max_: #after intervals
        intervals.append(Interval(fst, snd))
        return intervals
    elif fst < min_ and snd > max_: #contains all intervals
        return [Interval(fst, snd)]
    else: #merging situations
        k = 0
        b = -1
        e = -1
        b_between = False
        e_between = False
        while k < len(intervals)-1 and (b == -1 or e == -1):
            cur = intervals[k]
            nxt = intervals[k+1]
            # check inside an interval
            if cur.start <= fst and fst <= cur.end:
                b = k
            if cur.start <= snd and snd <= cur.end:
                e = k
            # check if between intervals
            if fst > cur.end and fst < nxt.start:
                b = k+1
                b_between = True
            if snd > cur.end and snd < nxt.start:
                e = k+1
                e_between =True
            k += 1
        if k == len(intervals)-1:
            cur = intervals[-1]
            if cur.start <= fst and fst <= cur.end:
                b = k
            if cur.start <= snd and snd <= cur.end:
                e = k
            if snd > cur.end:
                e = k+1
        # insert in middle, no merge:
        if b_between and e_between:
            if b == e:
                intervals.insert(b, Interval(fst, snd))
                return intervals
            else:
                n = Interval(fst, snd)
                res = []
                res.extend(intervals[:b])
                res.append(n)
                res.extend(intervals[e:])
                return res
        elif not b_between and not e_between:
            if b == e:
                return intervals
            else:
                n = None
                if b == -1:
                    n = Interval(fst, intervals[e].end) 
                elif e == len(intervals):
                    n = Interval(intervals[b].start, snd)
                else:
                    n = Interval(intervals[b].start, intervals[e].end)
                res = []
                if b != -1:
                    res.extend(intervals[:b])
                res.append(n)
                res.extend(intervals[e+1:])
                return res
        else:
            res = []
            res.extend(intervals[:max(0, b)])
            if b_between:
                n = Interval(fst, max(snd, intervals[e].end))
                res.append(n)
                res.extend(intervals[e+1:])
            else:
                n = Interval(min(fst, intervals[b].start), snd)
                res.append(n)
                res.extend(intervals[e:])
            return res