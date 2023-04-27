import heapq
from sys import stdin as s
from collections import deque

n, m = map(int, s.readline().split())

floor = []

for i in range(n):
    floor.append(list(s.readline().rstrip()))

visited = [[False for _ in range(m)] for _ in range(n)]

count = 0

def garo_bfs(y, x):
    garo_queue = deque()
    garo_queue.append((y, x))
    visited[y][x] = True

    while garo_queue:
        now_y, now_x = garo_queue.popleft()

        for dir in [[now_y, now_x-1], [now_y, now_x+1]]:
            new_y = dir[0]
            new_x = dir[1]

            if 0 <= new_x < m and not visited[new_y][new_x] and floor[new_y][new_x] == "-":
                visited[new_y][new_x] = True
                garo_queue.append((new_y, new_x))

def sero_bfs(y, x):
    sero_queue = deque()
    sero_queue.append((y, x))
    visited[y][x] = True

    while sero_queue:
        now_y, now_x = sero_queue.popleft()

        for dir in [[now_y - 1, now_x], [now_y + 1, now_x]]:
            new_y = dir[0]
            new_x = dir[1]

            if 0 <= new_y < n and not visited[new_y][new_x] and floor[new_y][new_x] == "|":
                visited[new_y][new_x] = True
                sero_queue.append((new_y, new_x))

for i in range(n):
    for j in range(m):
        # 가로 찾기
        if not visited[i][j] and floor[i][j] == "-":
            count += 1
            garo_bfs(i, j)
        # 세로 찾기
        if not visited[i][j] and floor[i][j] == "|":
            count += 1
            sero_bfs(i, j)

print(count)