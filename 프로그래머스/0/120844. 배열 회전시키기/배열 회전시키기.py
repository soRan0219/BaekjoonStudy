def solution(numbers, direction):
    answer = []
    tmp = []
    numbers_len = len(numbers)
    if(direction=="right"): 
        tmp = [numbers[numbers_len-1]]
        answer = tmp + numbers[0:numbers_len-1]
    else: 
        tmp = [numbers[0]]
        answer = numbers[1:numbers_len] + tmp
    return answer