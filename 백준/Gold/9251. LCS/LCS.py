from sys import stdin as s
import sys

a = s.readline().rstrip()
b = s.readline().rstrip()

n = len(a)
m = len(b)

dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

'''
for i in dp:
    print(*i)

'''

for i in range(1, n+1):   # a
    for j in range(1, m+1):   # b
        if a[i-1] == b[j-1]:     # 같다면
            dp[i][j] = dp[i-1][j-1] + 1
        else:   # 다르다면
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])


print(dp[n][m])