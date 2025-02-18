def solution(numbers, k):
    ball = 0
    for i in range(k-1):
        ball += 2
        if len(numbers) - 1 < ball:
            ball -= len(numbers)
    return numbers[ball]