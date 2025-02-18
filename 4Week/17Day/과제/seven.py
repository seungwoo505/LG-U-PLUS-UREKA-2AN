import re

def solution(my_string):
    number = 0
    my_list = re.sub(r'[^0-9]', " ", my_string).split(" ")
    for i in my_list:
        if i.isnumeric():
            number += int(i)
    return number