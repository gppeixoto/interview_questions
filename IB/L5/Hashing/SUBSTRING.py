"""
You are given a string, S, and a list of words, 
L, that are all of the same length.

Find all starting indices of substring(s) in S that is 
a concatenation of each word in L exactly once and 
without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
"""
def foo(A, B):
    if not B or not A:
        return []
    hashsum = sum(hash(subs) for subs in B)
    wsize = len(B[0])
    lsize = len(B)
    res = []
    for i in xrange(len(A)):
        hs = 0
        for j in xrange(i, i+lsize*wsize, wsize):
            hs += hash(A[j:j+wsize])
        if hs == hashsum:
            res.append(i)
    return res
    

def findSubstring(A, B):
    hashSum = sum([hash(b) for b in B])
    wordSize = len(B[0])
    hashes = [hash(A[i-wordSize:i]) for i in xrange(wordSize, len(A)+1)]
    
    indices = []
    substrSize = len(B) * wordSize
    for i in xrange(wordSize):
        rollingHash = 0
        for j in xrange(i, len(hashes), wordSize):
            rollingHash += hashes[j]
            if j-i+wordSize >= substrSize:
                if j >= substrSize:
                    rollingHash -= hashes[j-substrSize]
                if rollingHash == hashSum:
                    indices.append(j+wordSize-substrSize)
    indices.sort()
    return indices