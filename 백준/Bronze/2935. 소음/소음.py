a = int(input())
operator = str(input())
b = int(input())


def add(a, b):
    result = a + b
    return result


def multiply(a, b):
    result = a * b
    return result


if(operator == '*'):
    print(multiply(a, b))
elif(operator == '+'):
    print(add(a, b))
