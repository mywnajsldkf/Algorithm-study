# https://pacific-ocean.tistory.com/131

a_list = []
b_list = []

for i in range(3):

    a, b = map(int, input().split())

    a_list.append(a)
    b_list.append(b)


def find_a(a_list):
    if(a_list[0] == a_list[1]):
        result_a = a_list[2]
    if(a_list[0] == a_list[2]):
        result_a = a_list[1]
    if(a_list[1] == a_list[2]):
        result_a = a_list[0]

    return result_a


def find_b(b_list):
    if(b_list[0] == b_list[1]):
        result_b = b_list[2]
    if(b_list[0] == b_list[2]):
        result_b = b_list[1]
    if(b_list[1] == b_list[2]):
        result_b = b_list[0]

    return result_b


print(find_a(a_list), find_b(b_list))
