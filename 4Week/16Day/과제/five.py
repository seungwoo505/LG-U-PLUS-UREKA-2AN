def solution(numbers):
    answer = -100000001
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            print(numbers[i], numbers[j])
            if answer < numbers[i] * numbers[j]:
                answer = numbers[i] * numbers[j]
    return answer