def popcount(number, bit_counter):
    num = number
    counter = 0
    while num != 0: # 5,6回程度
        bit_con = 0
        if counter == 0:
            bit_con = bit_counter  
        else:
            bit_con = bin(num).count('1')
        num = num % bit_con
        counter += 1

    return counter

if __name__ == "__main__":
    import sys 

    readline = sys.stdin.readline 

    N = int(input())
    X_str= readline()
    X = list(X_str)
    bit_count = X_str.count('1')

    for i in range(N):
        # ビットの反転
        x_copy = X.copy()
        bit_count_n = bit_count
        if x_copy[i] == '0':
            x_copy[i] = '1'
            bit_count_n += 1
        else:
            x_copy[i] = '0'
            bit_count_n -= 1

        bit_int = int("".join(x_copy), 2)

        print(popcount(bit_int, bit_count_n))




