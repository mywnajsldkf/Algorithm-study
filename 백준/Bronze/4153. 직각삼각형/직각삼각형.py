import math
go = True

while go:
    triangle = list(map(int, input().split()))
    if 0 in triangle:
        break
    
    triangle.sort()

    if math.pow(triangle[2], 2) == math.pow(triangle[0], 2) + math.pow(triangle[1], 2):
        print("right")
    else:
        print("wrong")