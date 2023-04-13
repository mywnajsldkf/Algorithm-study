from sys import stdin as s
from itertools import combinations

N, S = map(int, s.readline().split())

numbers = list(map(int, s.readline().split()))

count = 0

for i in range(N):
    comList = list(combinations(numbers, i+1))
    for j in comList:
        if(sum(j) == S):
            count += 1

print(count)