def solution(my_string):
    list_string = list(my_string)
    answer = ''
    for i in list_string:
        if i.isupper():
            answer += i.lower()
        else:
            answer += i.upper()
    return answer