"""
Given an absolute path for a file (Unix-style), simplify it.
Examples:
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
"""
def simplifyPath(A):
    st = []
    dir_s = A.split("/")
    for dir_ in dir_s:
        if not dir_ or dir_ == ".":
            continue
        if dir_ != "..":
            st.append(dir_)
        elif dir_ == ".." and st:
            st.pop()
    ret = "/"
    if st:
        for dir_ in st[:-1]:
            ret += dir_ + "/"
        ret += st[-1]
    return ret