from sys import stdin as s

N = int(s.readline())

numbers = list(map(int, s.readline().split()))

c = 0

for i in numbers:
    count = 0

    for j in range(1, i+1):
        if(i % j == 0):
            count += 1

    if(count == 2):
        c += 1

print(c)