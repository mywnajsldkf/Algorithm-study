try_number = int(input())

for i in range(try_number):
    str_list = list(map(str, input()))
    repeat_number = int(str_list.pop(0))
    str_list.pop(0)

    result_str = []

    for i in range(len(str_list)):
        result_str.append(str_list[i]*repeat_number)

    print(''.join(result_str))
