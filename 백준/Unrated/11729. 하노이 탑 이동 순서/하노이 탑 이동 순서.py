from sys import stdin as s

N = int(s.readline())

def hanoi(n, start, temp, end):
    if(n <= 1):
        print(start, end)
    else:
        hanoi(n-1, start, end, temp)
        print(start, end)
        hanoi(n-1, temp, start, end)

print(2 ** N - 1)
hanoi(N, 1, 2, 3)