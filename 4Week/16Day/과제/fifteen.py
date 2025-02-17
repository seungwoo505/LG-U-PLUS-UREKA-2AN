def solution(age):
    list_age = list(str(age))
    answer = ''
    for i in list_age:
        answer += chr(97 + int(i))
    return answer