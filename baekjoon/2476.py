# https://claude-u.tistory.com/227

n = int(input())

a_list = []
reward_list = []


for i in range(n):
    a = list(map(int, input().split()))
    a_list.append(a)


def cal_reward(a):
    a_set = set(a)

    if(len(a_set) == 1):
        reward = 10000+a[0]*1000
    elif(len(a_set) == 2):
        if(a.count(a[0]) == 1):
            reward = 1000 + a[1]*100
        elif(a.count(a[0]) == 2):
            reward = 1000 + a[0]*100
    elif(len(a_set) == 3):
        reward = max(a_set)*100

    return reward


for i in range(n):
    reward_list.append(cal_reward(a_list[i]))

    i += 1

print(max(reward_list))
