import math

def solution(n):
    answer = 0
    for num in range(3, n+1): 
        divisor = set()
        for i in range(1, int(math.sqrt(num))+1):
            if(num%i == 0): 
                divisor.add(i)
                divisor.add(num//i)
        if(len(divisor) >= 3): answer += 1
    return answer