# 처음에 단순하게 두번 중첩해서 사용했음 -> 줄일 수 있음

while(1):
    a, b = map(int, input().split())

    if(a == 0 and b == 0):
        break
    if (a > b):
        print("Yes")
    else:
        print("No")
