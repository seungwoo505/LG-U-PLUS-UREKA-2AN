def solution(i, j, k):
    count = 0
    k_string = str(k)
    for n in range(i, j+1):
        for m in list(str(n)):
            if k_string == m:
                count += 1
    return count