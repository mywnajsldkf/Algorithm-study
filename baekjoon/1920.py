
N = int(input())
setA = list(map(int, input().split()))

M = int(input())
setB = list(map(int, input().split()))

setA = sorted(setA)

i = 0

answer_list = []

left, right = 0, len(setA)-1


def find_number(array, target, left, right):
    middle = round((left+right)/2)

    if left > right:
        return 0

    if target == array[middle]:
        return 1
    elif target > array[middle]:
        left = middle + 1
        return find_number(array, target, left, right)
    elif target < array[middle]:
        right = middle - 1
        return find_number(array, target, left, right)


def find_sameNumber(array, left, right):

    for i in setB:
        result = find_number(array, i, left, right)

        answer_list.append(result)

    return answer_list


answer_list = find_sameNumber(setA, left, right)

for i in answer_list:
    print(i)


# 시간 초과 발생한 솔루션
'''
def find_sameNumber():
    for i in range(M):
        if setB[i] in setA:
            answer = 1
        else:
            answer = 0

        answer_list.append(answer)

        i += 1

    return answer_list
'''
