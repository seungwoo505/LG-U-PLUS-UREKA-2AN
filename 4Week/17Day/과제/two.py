def solution(num_list, n):
    answer = []
    for i in range(0, len(num_list), n):
        answer2 = []
        for j in range(i, i + n):
            answer2.append(num_list[j])
        answer.append(answer2)
    return answer