def solution(dot):
    if 0 < dot[0] and 0 < dot[1]:
        return 1
    elif 0 > dot[0] and 0 < dot[1]:
        return 2
    elif 0 > dot[0] and 0 > dot[1]:
        return 3
    elif 0 < dot[0] and 0 > dot[1]:
        return 4