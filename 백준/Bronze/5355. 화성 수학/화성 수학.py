def multiply_o(number):
    number = number*3
    return number


def add_o(number):
    number = number+5
    return number


def subtract_o(number):
    number = number - 7
    return number


def solve_problem(problem):
    problem = problem.split()

    answer = float(problem.pop(0))

    while len(problem) != 0:

        operator = problem.pop(0)

        if(operator == "@"):
            answer = multiply_o(answer)
        elif(operator == "%"):
            answer = add_o(answer)
        elif(operator == "#"):
            answer = subtract_o(answer)

    return answer


def start_game():
    t_number = int(input())

    problems = [input() for i in range(t_number)]

    for i in range(t_number):
        print("%.2f" % solve_problem(problems[i]))


start_game()
