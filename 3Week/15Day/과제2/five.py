def solution(money):
    m = money // 5500
    answer = [m, money - m * 5500]
    return answer