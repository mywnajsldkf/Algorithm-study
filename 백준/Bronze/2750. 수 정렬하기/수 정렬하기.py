a = int(input())

nums = []
for i in range(a):
    nums.append(input())

b = list(map(int,nums))

b.sort()

for i in b:
    print(i)