hour, minute, second = map(int, input().split())
cooking_second = int(input())

# 몫
second += cooking_second
minute += second // 60 
hour += minute // 60

# 나머지 다루기
second %= 60
minute %= 60
hour %= 24

print(hour, minute, second)
