import sys
from sys import stdin as s

N = int(s.readline())

l = [list(map(int, s.readline().split())) for _ in range(N)]

visit = [False]*N
m = sys.maxsize

def dfs(depth, start, cost):
    global m

    if depth == N-1 and l[start][0] != 0:
        m = min(m, cost+l[start][0])
        return
    for i in range(N):
        if not visit[i] and l[start][i] != 0:
            visit[i] = True
            dfs(depth+1, i, cost+l[start][i])
            visit[i] = False

visit[0] = True
dfs(0,0,0)
print(m)
