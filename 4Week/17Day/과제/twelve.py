def solution(n):
    answer = []
    count = 2
    while count <= n:
        if n % count == 0:
            n /= count
            if count not in answer:
                answer.append(count)
        else:
            count += 1
    return answer