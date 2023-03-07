a, b, c = map(int, input().split())


def cal_reward(a, b, c):
    if(a == b == c):
        reward = 10000+a*1000
    elif(a != b and b != c and c != a):
        max = find_max(a, b, c)
        reward = max*100
    else:
        same_number = find_same(a, b, c)
        reward = 1000+same_number*100

    return reward


def find_max(a, b, c):
    numbers = [a, b, c]
    max = a
    for i in numbers:
        if(max < i):
            max = i

    return max


def find_same(a, b, c):
    numbers = [a, b, c]
    numbers.sort()
    same_number = numbers[1]
    return same_number


print(cal_reward(a, b, c))
