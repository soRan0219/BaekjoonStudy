def solution(n):
    answer = 1
    
    if(n%6 == 0): return n//6
    while(True):
        if(answer*6 % n == 0): return answer
        answer += 1
    #return answer