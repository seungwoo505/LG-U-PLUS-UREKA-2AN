def solution(my_string):
    list_string = list(my_string)
    for i in range(len(list_string)):
        if list_string[i] == "":
            continue
        for j in range(i + 1, len(list_string)):
            if list_string[i] == list_string[j]:
                list_string[j] = ""
    return ''.join(list_string)