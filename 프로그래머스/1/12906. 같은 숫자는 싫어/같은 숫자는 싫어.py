def solution(arr):
    answer = []
    stack = []
    
    arr.reverse()
    stack.append(arr[0])
    
    for a in arr[1:]:
      if stack[-1] != a:
        stack.append(a)
        
    while(len(stack) > 0):
      answer.append(stack.pop())
    return answer