def solution(my_string):
    answer = ''
    str = my_string.lower()
    strList = []
    for s in str:
        strList.append(s)
    answer = ''.join(sorted(strList))
    return answer