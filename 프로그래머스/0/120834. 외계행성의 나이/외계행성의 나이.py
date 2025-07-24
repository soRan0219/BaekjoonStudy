def solution(age):
    answer = ''
    strAge = str(age)
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    for s in strAge:
        i = int(s)
        answer += alphabet[i]
    return answer