def solution(bin1, bin2):
    max_length = max(len(bin1), len(bin2))
    list_bin1 = list(bin1.zfill(max_length))[::-1]
    list_bin2 = list(bin2.zfill(max_length))[::-1]
    carry = 0
    answer = ''
    for i in range(max_length):
        S = int(list_bin1[i]) + int(list_bin2[i]) + carry
        if S >= 2:
            carry = 1
            S = S - 2
        else:
            carry = 0
        answer = f'{S}' + answer
    if carry == 1:
        answer = f'{carry}' + answer
    return answer