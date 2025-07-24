def solution(order):
    answer = 0
    arr = []
    string = str(order)
    for s in string: arr.append(s)
    
    for a in arr:
        if(a=='3' or a=='6' or a=='9'): answer += 1
    
    return answer