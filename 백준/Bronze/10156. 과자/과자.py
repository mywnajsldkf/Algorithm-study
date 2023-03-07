k, n, m = map(int, input().split())

total_m = k * n


def printPmoney(total_m, m):
    if(total_m > m):
        moneyResult = total_m - m
    else:
        moneyResult = 0

    return moneyResult


print(printPmoney(total_m, m))
