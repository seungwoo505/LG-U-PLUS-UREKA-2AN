def solution(price):
    if price >= 500000: # 50만원
        return int(price * 0.80)
    elif price >= 300000: # 30만원
        return int(price * 0.90)
    elif price >= 100000: # 10만원
        return int(price * 0.95)
    return price