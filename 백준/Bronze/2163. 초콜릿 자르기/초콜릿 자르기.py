chocolate = list(map(int, input().split()))

n = chocolate[0]
m = chocolate[1]

total = (n-1) + (m-1)*n
print(total)