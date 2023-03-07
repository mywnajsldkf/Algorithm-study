t_n = int(input())


def LCM(a, b):

    result = int((a * b) / GCD(a, b))

    return result


def GCD(a, b):
    while(a % b != 0):   # b가 자연수일 동안(a % b != 0)

        a, b = b, a % b

    return b


for i in range(t_n):
    a, b = map(int, input().split())

    print(LCM(a, b))
