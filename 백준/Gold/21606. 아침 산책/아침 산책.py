from sys import stdin as s

N = int(s.readline().rstrip())

node = list(s.readline().rstrip())

school = [[] for i in range(N+1)]

count = 0

def dfs(start):
    # visited[start] = True
    global count
    # 시작점에서 인접한 점을 찾는다.

    # 실내를 찾으면 -> count 더하고 return
    # 실외를 찾으면 계속 간다.
    for point in school[start]:
        if not visited[point]:
            # 0(실외)를 만나면 탐색한다.
            if node[point-1] == '0':
                visited[point] = True
                dfs(point)
            # 1(실내)를 만나면 끝난다.
            elif node[point-1] == '1':
                visited[point] = True
                count += 1

for i in range(N-1):
    a, b = map(int, s.readline().split())
    school[a].append(b)
    school[b].append(a)

for i in range(1, N+1):
    visited = [False for i in range(N + 1)]
    visited[i] = True
    if node[i-1] == '0':
        continue
    elif node[i-1] == '1':
        dfs(i)

print(count)