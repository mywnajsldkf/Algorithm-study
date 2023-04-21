from sys import stdin as s

import heapq
from heapq import heappush, heappop

# 입력
N = int(s.readline())
arr = []
height = [0] * N
q = []

# end: 현재 i번째 건물의 끝나는 지점 저장
end = [0] * N
# check: 현재까지 만난 끝점을 저장하는 set
check = set()

for i in range(N):
    a, b, c = map(int, s.readline().split())
    # 시작점(1)과 끝점(-1)을 받는다.
    arr.append((a, i, 1))
    arr.append((c, i, -1))
    height[i] = b
    end[i] = c

# 그림2, 그림3에 따라 정렬
# 첫번째: 시점이 앞서있는가
# 두번째: 시점이 같으면 시작점인가
# 세번째: 시점도 같고 둘 다 시작점이면 높이가 더 높은가

arr.sort(key=lambda x: (x[0], -x[2], -height[x[1]]))

# now: 현재 최고 높이
now = 0
ans = []
for i in range(len(arr)):
    # point: 시점, idx: 건물 인덱스, dir: 시작인가 끝인가
    point, idx, dir = arr[i]

    # 시작점인 경우(빨간점)
    if dir == 1:
        # 높이가 갱신된다면 -> 새로운 스카이라인이 된다.
        if now < height[idx]:
            now = height[idx]
            ans.append((point, now))
        # 높이가 갱신되는 것과 상관없이 현재 건물의 높이와 끝점을 최대 힙에 저장한다.
        heappush(q, (-height[idx], end[idx]))

    # 끝점인 경우(파란점)
    else:
        # 현재 시점이 끝났기 때문에 set에 끝점의 시점을 저장
        check.add(point)
        # 최대 높이가 끝난 건물이 아닐 때까지 pop
        while q:
            if q[0][1] not in check:
                break
            heappop(q)

        # 힙이 비었다면 스카이라인 높이는 0
        if not q:
            if now:
                now = 0
                ans.append((point, now))

        # 힙이 있다면 현재 높이와 비교 시 변동이 있으 그 높이가 그 다음으로 높은 건물이되어, 스카이라인 높이가 갱신된다.
        else:
            if -q[0][0] != now:
                now = -q[0][0]
                ans.append((point, now))

for i in ans:
    print(i[0], i[1], end=' ')