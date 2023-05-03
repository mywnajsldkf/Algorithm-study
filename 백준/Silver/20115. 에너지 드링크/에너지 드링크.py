from sys import stdin as s
import sys
from collections import deque

n = int(s.readline())
drink = list(map(int, s.readline().split()))
drink.sort()

result = drink[-1]

for i in range(n-1):
    result += drink[i] / 2

if result % 1 != 0:
    print(result)
else:
    print(int(result))