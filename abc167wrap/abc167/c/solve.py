import numpy as np
import sys 
import itertools as it 

readline = sys.stdin.readline 

N, M, X = map(int, readline().split())

CA = []
for i in range(N):
    CA.append(readline().split())


# 理解度をX以上にする組み合わせをすべて選び、最小金額を求める
# sigma_n{C_r}は4096通り、全探索でもよさそう
arr_CA = np.array(CA, np.int64)
achieve_X = []
for select_book_num in range(N):
    for combination in it.combinations(arr_CA, select_book_num + 1): # ここまでで4096ループ
        sum = np.sum(np.array(combination, np.int64), axis=0, dtype=np.int64)    
        if sum[1:].min() >= X:
            achieve_X.append(sum)


if len(achieve_X) == 0:
    print(-1)
else:
    arr_achieve_X = np.array(achieve_X)
    print(arr_achieve_X[:, 0].min())
