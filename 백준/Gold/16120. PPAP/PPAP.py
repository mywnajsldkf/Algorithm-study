from sys import stdin as s

line = s.readline().rstrip()
stack = []

if "A" not in line and len(line) == 1:
    print("PPAP")
else:
    for i in range(len(line)):
        now = line[i]
        # 길이가 0이면 집어 넣는다.

        # P를 만나면 확인한다.
        # 길이가 3 이상이면 -> 확인한다.

        # 길이가 3이하면 집어 넣는다.
        if len(stack) < 3:
            stack.append(now)
        else:
            # A가 나오면 집어넣는다.
            if now == 'A':
                stack.append(now)
            # P가 나오면 PPAP인지 확인한다.
            else:
                temp = "P"

                for i in range(3):
                    temp += stack[-1 - i]

                if temp == "PAPP":
                    for j in range(3):
                        stack.pop()
                stack.append("P")


    if len(stack) == 1 and stack.pop() == "P":
        print("PPAP")
    else:
        print("NP")