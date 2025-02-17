import re

def solution(my_string):
    list_string = list(re.sub(r'[^ 0-9]', '', my_string))
    answer = []
    for i in range(len(list_string)):
        answer.append(int(list_string[i]))
    answer.sort()
    return answer