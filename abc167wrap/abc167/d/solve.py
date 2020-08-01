import numpy as np 
import sys 

readline = sys.stdin.readline

N, K = map(int, readline().split())
A = list(map(int, readline().split()))

# 愚直にやると計算量O(K)でTLEになる
# 同じ街にいったら操作打ち切りで配列を完結させる

# Teleport順の配列を作る
teleport = [1]
next_town = 1
for i in range(K):
    next_town = A[next_town - 1]
    if next_town in teleport:
        dupulicate_town = next_town
        dupulicate_index = teleport.index(dupulicate_town)
        dupulicate_list = teleport[dupulicate_index:]
        break
    else:
        teleport.append(next_town)


if len(teleport) - 1 == K:
    print(teleport[-1])
else: # ループに入る場合
    consumption = len(teleport) - 1
    roop_num = K - consumption
    roop_index = roop_num % len(dupulicate_list)
    if roop_index == 0:
        print(dupulicate_list[-1])
    else:
        print(dupulicate_list[roop_index - 1])

