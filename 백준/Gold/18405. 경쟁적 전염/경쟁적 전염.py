import heapq
from sys import stdin as s
from collections import deque

n, k = map(int, s.readline().split())

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

virus = []

for i in range(n):
    virus.append(list(map(int, s.readline().split())))

ss, y, x = map(int, s.readline().split())

visited = [[0 for _ in range(n)] for _ in range(n)]

tmp = []

for i in range(n):
    for j in range(n):
        # 바이러스가 채워져 있으면
        if virus[i][j]:
            tmp.append([virus[i][j], i, j])
            visited[i][j] = virus[i][j]

tmp.sort()
q = deque()

def bfs():
    global ss
    for num, now_y, now_x in tmp:
        q.append([now_y, now_x, num])

    while len(q) != 0 and ss != 0:
        size = len(q)
        ss -= 1  # 바이러스 초를 줄인다.
        for p in range(size):
            now_y, now_x, num = q.popleft()
            for i in range(4):
                ny, nx = now_y + dy[i], now_x + dx[i]
                if 0 > ny or ny >= n or 0 > nx or nx >= n:
                    continue
                if visited[ny][nx]:
                    continue
                visited[ny][nx] = num
                q.append([ny, nx, num])
bfs()
print(visited[y - 1][x - 1])
