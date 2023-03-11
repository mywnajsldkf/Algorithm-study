while True:
    number = input()
    if(number == "0"):
        break
    
    answer = "no"

    if number == number[::-1]:
        answer = "yes"
    print(answer)