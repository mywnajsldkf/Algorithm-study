n = int(input())

factorization = []

divide_number = 2

while n > 1:
    if(n % divide_number == 0):
        n = n // divide_number
        factorization.append(divide_number)
    elif(n % divide_number != 0):
        divide_number += 1
    elif(n == 1):
        break

for i in factorization:
    print(i)
