def solution(array):
    answer = 0
    for i in array:
        list_i = list(str(i))
        for j in list_i:
            if j == "7":
                answer += 1
    return answer