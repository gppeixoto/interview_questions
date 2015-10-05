def next_bigger(n):
    c0 = 0; c1 = 0; p = 0
    tmp = n
    while (int.bit_length(tmp) > 0):
        one = tmp & 1
        zero = (~tmp >> 1) & 1
        """if one and zero:
            break
        else:
            p += 1
            tmp >>= 1"""
        if one:
            c1 += 1
            if zero:
                break
            else:
                p += 1
                tmp >>= 1
        else:
            c0 += 1
            p += 1
            tmp >>= 1
    # step1: set p+1 and clear p
    tmp = n
    tmp |= (1 << (p+1))
    tmp &= ~(1 << p)
    
    # step2: clear [0 .. p-1]
    tmp &= ~((1 << p) - 1)

    #step 3: set c1 right-most bits
    tmp |= (1 << c1-1)-1
    return tmp 
