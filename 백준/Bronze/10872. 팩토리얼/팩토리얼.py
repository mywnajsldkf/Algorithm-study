n = int(input())

result = 1

for i in range(n):
    result *= n
    n += -1

print(result)