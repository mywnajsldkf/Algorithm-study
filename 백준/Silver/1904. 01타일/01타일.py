from sys import stdin as s
import sys

n = int(s.readline())
dp = [0] * 1000001

dp[1] = 1
dp[2] = 2


def tile(n):
    for i in range(3, n+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 15746
    return dp[n]

print(tile(n))