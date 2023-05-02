from sys import stdin as s
import sys
from collections import deque

n = int(s.readline())

# count, to
dp = [[0, 0] for i in range(n+1)]

for i in range(2, n + 1):
    dp[i][0] = dp[i - 1][0] + 1
    dp[i][1] = i - 1

    if i % 2 == 0:
        if dp[i][0] > dp[i // 2][0] + 1:
            dp[i][0] = dp[i // 2][0] + 1
            dp[i][1] = i // 2

    if i % 3 == 0:
        if dp[i][0] > dp[i // 3][0] + 1:
            dp[i][0] = dp[i // 3][0] + 1
            dp[i][1] = i // 3

print(dp[n][0])

loc = n
print(loc, end=' ')
for i in range(dp[n][0]):
    print(dp[loc][1], end=' ')
    loc = dp[loc][1]