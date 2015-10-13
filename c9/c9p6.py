import sys

def parenthesis(string, n, left, right):
    if len(string) == 2*n:
        print string
    if left < n:
        parenthesis(string+"(", n, left+1, right)
    if right < left:
        parenthesis(string+")", n, left, right+1)

def parens(n):
    parenthesis("(", n, 1, 0)

if __name__ == "__main__":
    n = int(sys.argv[1])
    parens(n)