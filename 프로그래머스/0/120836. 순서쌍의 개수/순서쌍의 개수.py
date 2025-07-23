import math

def solution(n):
    s = set()
    for i in range(int(math.sqrt(n))+1):
        if(i==0): continue
        if(n%i == 0): 
            s.add((i, n//i))
            s.add((n//i, i))
    return len(s)