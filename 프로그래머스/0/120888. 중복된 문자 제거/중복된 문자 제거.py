def solution(my_string):
    answer = my_string[0]
    for s in my_string: 
        if s not in answer: answer += s
    return answer