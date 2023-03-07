s = int(input())

count_n = 0

cal_result = s
i = 1

while(cal_result - i >= 0):
    cal_result = cal_result - i
    i += 1

print(i-1)
