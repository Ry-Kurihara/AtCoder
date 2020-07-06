import sys
import numpy as np

readline = sys.stdin.readline 

N = int(input())
A = np.array(readline().split(), np.int64)
A_sort = np.sort(A)[::-1] # 降順ソート

count = 0
limit = 1
t = 0
for i in range(N - 1):
    if i == 0:
        count += A_sort[0]
    else:
        count += A_sort[limit]
        t += 1
        if t % 2 == 0:
            limit += 1
        

print(count)