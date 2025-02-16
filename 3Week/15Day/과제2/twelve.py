def solution(my_string):
    gather = ['a', 'e', 'i', 'o', 'u']
    for i in gather:
        if i in my_string:
            my_string = my_string.replace(i, "")
    return my_string