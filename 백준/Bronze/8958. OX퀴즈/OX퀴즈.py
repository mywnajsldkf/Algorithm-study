test = int(input())

def calScore(case):
    score = 0
    # right = True
    nowScore = 0
    for i in range(len(case)):
        if case[i] == 'O':
            nowScore += 1
            score += nowScore
        elif case[i] == 'X':
            nowScore = 0
    print(score)

for i in range(test):
    case = input()
    calScore(case)