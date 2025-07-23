import re

def solution(my_string):
    answer = 0
    digit = re.compile(r'[0-9]')
    strlist = digit.findall(my_string)
    for str in strlist:
        answer += int(str)
    return answer