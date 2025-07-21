def solution(angle):
    return 4 if angle==180 else (3 if angle>90 and angle<180 else (2 if angle==90 else 1))