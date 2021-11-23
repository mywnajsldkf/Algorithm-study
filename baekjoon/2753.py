year = int(input())


def find_leapyear(year):
    result = 0

    if(year % 4 == 0):
        if(year % 100 != 0 or year % 400 == 0):
            result = 1
        else:
            result = 0

    return result


print(find_leapyear(year))
