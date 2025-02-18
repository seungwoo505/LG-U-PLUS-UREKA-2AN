def solution(s):
    list_s = s.split(" ")
    number = 0
    last_num = 0
    for i in list_s:
        if i == "Z":
            number -= last_num
        else:
            number += int(i)
            last_num = int(i)
    return number