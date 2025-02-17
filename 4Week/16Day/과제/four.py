import re

def solution(my_string):
    list_string = list(re.sub(r'[^0-9]', '', my_string))
    number = 0
    for i in list_string:
        number += int(i)
    return number