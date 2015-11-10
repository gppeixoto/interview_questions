def swap(arr, i, j):
    tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp

def partition(A, lo, hi):
    pivot = A[lo]
    i = lo -1
    j = hi + 1
    while i < j:
        j -= 1
        while A[j] > pivot:
            j -= 1
        while A[i] < pivot:
            i += 1
        if i < j:
            swap(A, i, j)
    return j

def qs(A, lo, hi):
    if lo < hi:
        p = partition(A, lo, hi)
        qs(A, lo, p-1)
        qs(A, p+1, hi)

def quicksort(A):
    qs(A, 0, len(A)-1)