def solution(my_string):
    list_string = list(my_string.lower())
    list_string.sort()
    answer = ''.join(list_string)
    return answer