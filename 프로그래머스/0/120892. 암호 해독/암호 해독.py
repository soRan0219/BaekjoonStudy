def solution(cipher, code):
    answer = ''
    cipher2 = 'A'+cipher
    for idx in range(1, len(cipher2)):
        if(idx%code == 0): answer += cipher2[idx]
    return answer