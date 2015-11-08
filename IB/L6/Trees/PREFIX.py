"""
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}

"""
from string import ascii_lowercase as ascii

class node:
    def __init__(self):
        self.edges = dict()
        self.word = False
        self.prefix = False
        self.words = set()

def build_trie(stringList):
    root = node()
    for char in ascii:
        root.edges[char] = node()
    for k, s in enumerate(stringList):
        pres = []
        for i in xrange(len(s)):
            pres.append(s[:i+1])
        for j, prefix in enumerate(pres):
            cur = root.edges[prefix[0]]
            i = 1
            while i < len(prefix):
                n = cur.edges.get(prefix[i], None)
                if not n:
                    cur.edges[prefix[i]] = node()
                cur = cur.edges[prefix[i]]
                i += 1
            cur.prefix = True
            cur.words.add(k)
            if j == len(s)-1:
                cur.word = True
    return root

def shortestUniquePrefix(string, ind, trie):
    cur = trie
    pre = ''
    i = 0
    while i < len(string):
        cur = cur.edges[string[i]]
        pre += string[i]
        if len(cur.words) == 1 and ind in cur.words:
            break
        i += 1
    return pre

def scp(stringList):
    trie = build_trie(stringList)
    res = []
    for k, s in enumerate(stringList):
        res.append(shortestUniquePrefix(s, k, trie))
    return res