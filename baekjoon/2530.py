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

'''
hour, minute, second = map(int, input().split())
cooking_time = int(input())

def transfer_to_second(hour, minute, second):
    hour = hour * 3600
    minute = minute * 60
    
    total_second = hour + minute + second

    return total_second

now_second = transfer_to_second(hour, minute, second)
finish_second = now_second + cooking_time

def find_hour(finish_second):
    f_hour = finish_second // 3600
    return check_hour(f_hour)

def find_minute(finish_second):
    f_minute = finish_second % 3600
    return check_minute(f_minute)

def find_second(finish_second):
    
    left_minute = finish_second % 3600

    if(left_minute >= 60):
        f_second = left_minute % 60
    elif(left_minute < 60):
        f_second = 0

    return f_second    
 
def check_hour(hour):
    if(hour >= 24):
        hour = hour - 24
    elif(hour < 24):
        hour = hour

    return hour

def check_minute(minute):
    if(minute >= 60):
        minute = minute // 60
    elif(min < 60):
        minute = minute

    return minute

print(find_hour(finish_second), find_minute(finish_second), find_second(finish_second))
'''