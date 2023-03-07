num = int(input())
my_list = input()

a = list(my_list)
b = list(map(int, a))
print(sum(b))