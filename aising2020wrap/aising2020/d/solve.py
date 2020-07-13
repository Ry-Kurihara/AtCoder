def popcount(n):
    bit_count = bin(n).count('1')
    n = n % bit_count 
    return n

if __name__ == "__main__":
    import sys 

    readline = sys.stdin.readline 

    N = int(input())
    X = readline()
    bit_count = X.count('1')
    mod1 = int(X, 2) % (bit_count + 1)
    mod2 = int(X, 2) % (bit_count - 1) if (bit_count - 1) != 0 else 0

    for i in range(N):
        if X[i] == '0':
            X_rest = (mod1 + pow(2, N - 1 - i, bit_count + 1)) % (bit_count + 1)
        else:
            if bit_count - 1 != 0:
                X_rest = (mod2 - pow(2, N - 1 - i, bit_count - 1)) % (bit_count - 1)
            else:
                print(0)
                continue

        counter = 1
        while X_rest != 0:
            X_rest = popcount(X_rest)
            counter += 1
        print(counter)




