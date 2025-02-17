def solution(hp):
    '''
        장군개미 = 5
        병정개미 = 3
        일개미 = 1
    '''
    count = 0
    ant = [5, 3, 1]
    
    for i in ant:
        count += hp // i
        hp %= i
        
    return count
        