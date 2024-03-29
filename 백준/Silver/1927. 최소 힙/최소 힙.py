from heapq import heappop, heappush
from sys import stdin as s

N = int(s.readline())

heap = []

for i in range(N):
    number = int(s.readline())

    if number == 0:
        if len(heap) == 0:
            print("0")
        else:
            print(heappop(heap))

    else:
        heappush(heap, number)