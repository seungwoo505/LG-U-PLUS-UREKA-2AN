def solution(n):
    number = 1
    for i in range(1, 11):
        number *= i
        if n < number:
            return i - 1
        elif n == number:
            return i