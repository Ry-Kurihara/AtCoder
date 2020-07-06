import sys 
import numpy as np

readline = sys.stdin.buffer.readline

H, W, K = map(int, readline().split())
# 2次元配列に格納する
C_ij = []
for h in range(H):
    C_ij.append(input()) # bufferだとbがつくのでこちらに

ans = 0
# bit全探索[2重ループver]
for h_bit in range(2**H):
    for w_bit in range(2**W):
        black = 0
        for h in range(H):
            for w in range(W):
                if not((h_bit >> h) & 1) and not((w_bit >> w) & 1) and \
                C_ij[h][w] == '#':
                    black += 1
        if black == K:
            ans += 1

# 配列形式C_ij[H][0][W]
print(ans)