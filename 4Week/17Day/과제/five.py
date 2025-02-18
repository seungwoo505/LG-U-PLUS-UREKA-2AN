def solution(emergency):
    answer = [0 for i in emergency]
    sort_emergency = sorted(emergency, reverse=True)
    for i in range(len(sort_emergency)):
        answer[emergency.index(sort_emergency[i])] = i + 1
    return answer