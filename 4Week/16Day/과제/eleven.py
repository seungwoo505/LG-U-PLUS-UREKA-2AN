def solution(cipher, code):
    list_cipher = list(cipher)
    answer = ''
    for i in range(code, len(list_cipher) + 1, code):
        answer += list_cipher[i - 1]
    return answer