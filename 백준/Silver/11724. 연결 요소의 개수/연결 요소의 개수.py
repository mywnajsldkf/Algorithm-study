from sys import stdin as s
from collections import deque

N, M = map(int, s.readline().split())

connection = [[] for _ in range(N+1)]

for i in range(M):
    u, v = map(int, s.readline().split())
    connection[u].append(v)
    connection[v].append(u)

visited = [False for i in range(N+1)]

def bfs(start):
    queue = deque([start])
    visited[start] = True

    while len(queue) != 0:
        now = queue.popleft()
        for i in connection[now]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

count = 0
for i in range(1, N+1):
    if not visited[i]:
        count += 1
        bfs(i)

print(count)