import re

def solution(my_string):
    digit = re.compile(r'\d')
    answer = list(map(int, digit.findall(my_string)))
    answer.sort()
    return answer