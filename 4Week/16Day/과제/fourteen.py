def solution(n):
    m = 6
    count = 1
    answer = (m * count) / n
    while answer != int(answer):
        count += 1
        answer = (m * count) / n
    return count