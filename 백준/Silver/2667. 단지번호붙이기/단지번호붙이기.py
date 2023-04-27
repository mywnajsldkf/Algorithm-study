import heapq
from sys import stdin as s
from collections import deque

N = int(s.readline())

map = []

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

for i in range(N):
    map.append(list(s.readline().rstrip()))

visited = [[False for _ in range(N)] for _ in range(N)]

result = []
def bfs(y, x):
    count = 0
    queue = deque()
    queue.append((y, x))
    visited[y][x] = True

    while queue:
        now_y, now_x = queue.popleft()
        count += 1

        for dir in range(4):
            new_y = now_y + dy[dir]
            new_x = now_x + dx[dir]
            # 범위 확인
            if new_y < 0 or new_y >= N or new_x < 0 or new_x >= N:
                continue

            if not visited[new_y][new_x] and map[new_y][new_x] == "1":
                queue.append((new_y, new_x))
                visited[new_y][new_x] = True

    return count

total = 0

for i in range(N):
    for j in range(N):
        if map[i][j] == "1" and not visited[i][j]:
            total += 1
            bfs_count = bfs(i,j)
            result.append(bfs_count)


print(total)
result.sort()
for i in result:
    print(i)