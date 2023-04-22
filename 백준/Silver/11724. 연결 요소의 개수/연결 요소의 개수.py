from sys import stdin as s

N, M = map(int, s.readline().split())

connection = [[0 for i in range(N+1)] for j in range(N+1)]

for i in range(M):
    u, v = map(int, s.readline().split())
    connection[u][v] = 1
    connection[v][u] = 1

visited = [False for i in range(N+1)]

queue = []
count = 0


def dfs(n):
    queue.append(n)
    while len(queue) != 0:
        # print(len(queue))
        now = queue.pop()
        # print(now)
        visited[now] = True  # 방문 표시한다.
        # print(visited)
        for i in range(1, N+1):
            # 방문했다면 -> continue
            if visited[i]:
                continue
            #
            if connection[now][i] == 1:
                queue.append(i)


for i in range(1, N+1):
    # 이전에 방문했다면, 탐색하지 않는다.
    if not visited[i]:
        count += 1
        dfs(i)

# print(*connection, sep='\n')
print(count)
