import sys 
import numpy as np

readline = sys.stdin.readline 

N = int(input())

index = [0] * N

for x in range(1, 101):
    for y in range(1, 101):
        for z in range(1, 101):
            n = x**2 + y**2 + z**2 + x*y + y*z + z*x 
            if n <= N:
                index[n - 1] += 1


for i in index:
    print(i)