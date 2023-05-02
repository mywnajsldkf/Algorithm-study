from sys import stdin as s
import sys

n, m = map(int, s.readline().split())

numbers = [0]
numbers.extend(list(map(int, s.readline().split())))

size = len(numbers)

for i in range(2, size):
    numbers[i] += numbers[i-1]

for i in range(m):
    a, b = map(int, s.readline().split())
    print(numbers[b] - numbers[a-1])