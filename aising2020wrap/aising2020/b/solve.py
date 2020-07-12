import sys 

readline = sys.stdin.readline 

N = int(input())
A = readline().split()

counter = 0
for i in range(N):
    if (i+1) % 2 != 0:
        if int(A[i]) % 2 != 0:
            counter += 1

print(counter)