def solution(balls, share):
    # balls! / ((balls - share)! * share!)
    # 5 * 4 / 2!
    top = 1
    bottom = 1
    
    for i in range(share + 1, balls + 1):
        top *= i
    
    for i in range(1, balls - share + 1):
        bottom *= i
    
    return top / bottom