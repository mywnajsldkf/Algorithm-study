from sys import stdin as s

N = int(s.readline())
count = 0
def findCycle(n):
    global count
    count += 1

    if(count > 1 and n == N):
        return

    temp_N = n % 10 + n // 10

    new_N = 10*(n % 10) + temp_N % 10

    findCycle(new_N)

findCycle(N)
print(count-1)