"""
Given n non-negative integers representing the histogram’s bar 
height where the width of each bar is 1, find the area of
largest rectangle in the histogram.
"""
def largestRectangleArea(A):
    stack = []
    n = len(A)
    ret = 0
    tp = -1
    area_with_top = -1
    i = 0
    while i < n:
        if len(stack) == 0 or A[i] >= A[stack[-1]]:
            stack.append(i)
            i += 1
        else:
            tp = stack.pop()
            area_with_top = A[tp]*(i if len(stack) == 0 else i - stack[-1] - 1)
            if ret < area_with_top:
                ret = area_with_top
    while len(stack) != 0:
        tp = stack.pop()
        area_with_top = A[tp]*(i if len(stack) == 0 else i - stack[-1] - 1)
        if ret < area_with_top:
            ret = area_with_top
            
    return ret 
