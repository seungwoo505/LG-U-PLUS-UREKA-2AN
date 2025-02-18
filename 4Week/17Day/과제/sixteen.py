def solution(my_string):
    list_string = my_string.split(" ")
    answer = 0
    add_ant = 1
    
    for i in list_string:
        if i == "+":
            add_ant = 1
        elif i == "-":
            add_ant = -1
        else:
            answer += add_ant * int(i)
    return answer