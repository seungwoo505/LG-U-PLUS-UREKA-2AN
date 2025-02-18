def solution(numbers):
    list_numbers = list(numbers)
    number = ""
    answer = ""
    for i in list_numbers:
        number += i
        if check_number(number) >= 0:
            answer = answer + str(check_number(number))
            number = ""
    return int(answer)

def check_number(n):
    if "zero" == n:
        return 0
    elif "one" == n:
        return 1
    elif "two" == n:
        return 2
    elif "three" == n:
        return 3
    elif "four" == n:
        return 4
    elif "five" == n:
        return 5
    elif "six" == n:
        return 6
    elif "seven" == n:
        return 7
    elif "eight" == n:
        return 8
    elif "nine" == n:
        return 9
    else:
        return -1