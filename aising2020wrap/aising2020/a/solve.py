import sys 

readline = sys.stdin.readline

LRd = readline().split()
L = int(LRd[0])
R = int(LRd[1])
d = int(LRd[2])

counter = 0
for i in range(L, R+1):
    if i % d == 0:
        counter += 1

print(counter)