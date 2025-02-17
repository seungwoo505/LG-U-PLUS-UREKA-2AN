def solution(my_string, num1, num2):
    list_string = list(my_string)
    chage_string = list_string[num1]
    list_string[num1] = list_string[num2]
    list_string[num2] = chage_string
    
    return ''.join(list_string)