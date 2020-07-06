N = int(input())
S = [input() for i in range(N)]

AC = 0
WA = 0
TLE = 0
RE = 0

for input in S:
    if input == 'AC':
        AC += 1
    elif input == 'WA':
        WA += 1
    elif input == 'TLE':
        TLE += 1
    else:
        RE += 1

print("""AC x {ac}
WA x {wa}
TLE x {tle}
RE x {re}""".format(ac = AC, wa = WA, tle = TLE, re = RE))