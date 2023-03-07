score = [input() for i in range(5)]

for i in range(5):

    if int(score[i]) < 40:
        score[i] = 40
        
    else:
        score[i] = int(score[i])

result = sum(score)
print(round(result/len(score)))