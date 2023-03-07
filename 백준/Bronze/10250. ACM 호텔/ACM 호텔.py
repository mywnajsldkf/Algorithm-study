times = int(input())

string_list = []

for i in range(times):
    num_string = str(input())
    string_list.append(num_string)

for i in range(times):
    H, W, N = map(int, string_list[i].split())

    H_count = 0
    n = 0

    while H_count < N:
        H_count += H
        n += 1

    r_number = n
    r_floor = N-H*(r_number-1)

    if r_number >= 10:
        print(f"{r_floor}{r_number}")
    else:
        print(f"{r_floor}0{r_number}")