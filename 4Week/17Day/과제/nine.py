def solution(s):
    list_s = list(s)
    answer = []
    not_answer = []
    
    for i in list_s:
        if i in not_answer:
            continue
        
        if i not in answer:
            answer.append(i)
        else:
            answer.remove(i)
            not_answer.append(i)
    answer.sort()
    return ''.join(answer)