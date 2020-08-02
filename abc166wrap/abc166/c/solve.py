import numpy as np
import sys 

readline = sys.stdin.readline

N, M = map(int, readline().split())
H = list(map(int, readline().split()))

AB = [list(map(int, readline().split())) for _ in range(M)]

print(AB)

