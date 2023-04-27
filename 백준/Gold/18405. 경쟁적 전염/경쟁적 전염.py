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

visited = [[False for _i in range(n)] for _j in range(n)]

def bfs():
    while len(queue) > 0:
        now_y, now_x = queue.popleft()

        for dir in range(4):
            new_y = now_y + dy[dir]
            new_x = now_x + dx[dir]

            # 범위 확인
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= n:
                continue

            # 아직 채워지지 않았다면
            if virus[new_y][new_x] == 0:
                virus[new_y][new_x] = virus[now_y][now_x]

            # 이미 채워진 지점이라면 이전 것과 비교하여 작은 것을 업데이트해준다.
            if virus[new_y][new_x] != 0 and not visited[new_y][new_x]:
                virus[new_y][new_x] = min(virus[new_y][new_x], virus[now_y][now_x])


queue = deque()

for t in range(ss):
    for i in range(n):
        for j in range(n):
            # 방문하지 않았고,
            if not visited[i][j] and virus[i][j] != 0:
                visited[i][j] = True
                queue.append((i, j))
    bfs()

print(virus[y - 1][x - 1])
