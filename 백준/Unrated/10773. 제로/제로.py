from sys import stdin as s
N = int(s.readline())

stack = []

for i in range(N):
    number = int(s.readline())
    if number == 0:
        stack.pop()
    else:
        stack.append(number)

print(sum(stack))