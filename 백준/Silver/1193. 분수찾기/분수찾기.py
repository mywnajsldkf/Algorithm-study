n = int(input())

num = 0             # 계속해서 1씩 더해지는 변수, 분수가 위치하는 num
num_count = 0       # num이 1씩 더해질 때 n을 초과하지 않도록 제어하는 장치자

while num_count < n:
    num += 1
    num_count += num

num_count -= num    # 15 - 5
x = n-num_count

if num % 2 == 0:
    i = x
    j = num - x + 1
else:
    i = num - x +1
    j = x

# print(str(i) + "/" + str(j))
print(f"{i}/{j}")