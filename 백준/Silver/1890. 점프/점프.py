import heapq
from sys import stdin as s
from collections import deque

n = int(s.readline())

game = [[0] for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]

# 환경 설정
for i in range(n):
    game[i] = list(map(int, s.readline().split()))

dp[0][0] = 1

for y in range(n):
    for x in range(n):
        if y == n-1 and x == n-1:
            print(dp[y][x])
            break

        # 오른쪽으로 이동하는 경우
        if y + game[y][x] < n:
            dp[y + game[y][x]][x] += dp[y][x]

        # 왼쪽으로 이동하는 경우
        if x + game[y][x] < n:
            dp[y][x + game[y][x]] += dp[y][x]
