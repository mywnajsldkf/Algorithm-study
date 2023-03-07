def find(n):
    result = n
    for i in str(n):
        result += int(i)

    return result

num_list = []

for i in range(1,10001):
    num_list.append(i)

selfnum_list = []

for i in num_list:
    if find(i) < 10001:
        selfnum_list.append(find(i))
    else:
        continue

new_list = list(set(selfnum_list))

result_list = list(set(num_list) - set(selfnum_list))

result = sorted(result_list)

for i in result:
    print(i)
