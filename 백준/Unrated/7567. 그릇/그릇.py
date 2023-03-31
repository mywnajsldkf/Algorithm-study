a = input()

height = 10

status = a[0]

for i in range(1, len(a)):
    if(a[i] == status):
        height += 5
    else:
        height += 10
    status = a[i]

print(height)