import sys
from sys import stdin as s
sys.setrecursionlimit(10**6)

A, B, C = map(int, s.readline().split())

def multiply(a,b,c):
    if b == 1:
        return a % c
    if b % 2 == 0:
        return (multiply(a, b // 2, c) ** 2) % c
    else:
        return ((multiply(a,b // 2, c) ** 2) * a) % c

print(multiply(A, B, C))