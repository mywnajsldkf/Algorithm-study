from sys import stdin as s
import sys
from collections import deque

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

n = int(s.readline())

miro = []
for i in range(n):
    miro.append(list(map(int, s.readline().strip())))

visited = [[-1 for _ in range(n)] for _ in range(n)]

def bfs():
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = 0

    while queue:
        y, x = queue.popleft()
        if y == n-1 and x == n-1:
            return visited[y][x]

        for i in range(4):
            n_y = y + dy[i]
            n_x = x + dx[i]

            # 범위 확인
            if n_y < 0 or n_y >= n or n_x < 0 or n_x >= n:
                continue

            # 방문 확인
            if visited[n_y][n_x] == -1:
                if miro[n_y][n_x] == 1:
                    # 가장 앞에 넣는다. -> 흰색 돌을 먼저 다보고
                    queue.appendleft((n_y, n_x))
                    # 흰색 돌은 방문 횟수를 변화시키지 않는다.
                    visited[n_y][n_x] = visited[y][x]
                else:
                    queue.append((n_y, n_x))
                    visited[n_y][n_x] = visited[y][x] + 1

print(bfs())