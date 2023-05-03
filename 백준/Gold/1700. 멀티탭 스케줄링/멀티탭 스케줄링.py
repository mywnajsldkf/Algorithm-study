from sys import stdin as s
import sys

n, k = map(int, s.readline().split())

items = list(map(int, s.readline().split()))
answer = 0
plugin = []


def check(i):
    target = 0
    idx = -1
    for p in plugin:
        # i 이후에 안쓰인다면 뽑는다.
        if p not in items[i:]:
            return p
        # 인덱스로 어디 위치에 있는지 확인한다.
        if idx < items[i:].index(p):
            target = p
            idx = items[i:].index(p)
    return target


for i in range(k):
    # 아이템을 꽂을 수 있는 자리가 있다면
    if len(plugin) < n:
        # 아이템이 있다면 추가하지 않는다.
        if items[i] in plugin:
            continue
        # 아이템이 없다면 추가한다.
        else:
            plugin.append(items[i])

    # 아이템을 꽂을 수 있는 자리가 없다면 -> 빼고 꽂아야 한다.
        # 앞으로 쓰이지 않는다면 뽑는다.
        # 가장 나중에 쓰이는 것을 뽑는다.
    if not items[i] in plugin:
        plugin[plugin.index(check(i))] = items[i]
        answer += 1

print(answer)