def solution(num, k):
    str_num = str(num)
    str_k = str(k)
    answer = str_num.find(str_k)
    return answer if answer == -1 else answer + 1