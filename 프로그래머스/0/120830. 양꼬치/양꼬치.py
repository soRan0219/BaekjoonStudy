def solution(n, k):
    services = n//10
    k -= services
    return n*12000 + k*2000