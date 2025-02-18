def solution(before, after):
    list_before = list(before)
    list_after = list(after)
    
    for i in list_before:
        for j in list_after:
            if i == j:
                list_after.remove(j)
                break
    if list_after == []:
        return 1
    else:
        return 0