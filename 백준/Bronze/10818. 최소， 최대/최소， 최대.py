num = input()
my_list = []

my_list = list(map(int,input().split(' ')))

list_max = max(my_list)
list_min = min(my_list)

print(list_min, list_max)
