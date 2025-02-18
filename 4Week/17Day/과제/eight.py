def solution(array, n):
    min_length = [100, 100] #숫자, 차이
    
    for i in array:
        if abs(n - i) < min_length[1] or (abs(n - i) == min_length[1] and i < min_length[0]):
            min_length = [i, abs(n - i)]
    return min_length[0]