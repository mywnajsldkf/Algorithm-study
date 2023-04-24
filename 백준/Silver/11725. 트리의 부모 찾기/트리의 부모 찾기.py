from sys import stdin as s
from collections import deque

import sys

sys.setrecursionlimit(10 ** 6)

N = int(s.readline())

tree = [[] for i in range(N + 1)]

for i in range(N - 1):
    a, b = map(int, s.readline().split())
    tree[a].append(b)
    tree[b].append(a)

result = [0] * (N - 1)
visited = [False] * (N + 1)

for i in range(N+1):
    tree[i].sort()

def dfs(start):
    for i in tree[start]:
        if not visited[i]:
            visited[i] = True
            result[i - 2] = start
            dfs(i)


for i in range(1, N + 1):
    if not visited[i]:
        dfs(i)

for i in result:
    print(i)
