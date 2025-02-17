def solution(n):
    composite = 0
    for i in range(4, n + 1):
        count = 0
        for j in range(2, i):
            if i % j == 0:
                break
            else:
                count += 1
        if count + 2 != i:
            composite += 1
    return composite