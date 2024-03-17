'''
[그리디]
1. number 배열에 숫자 한개씩 스택에 넣음
2. peek < 탐색한 숫자 일때 스택에 넣음
'''
def solution(number, k):
    answer = ''

    # 맨 앞자리 스택에 넣어줌
    stack = [number[0]]

    # number 배열을 탐색
    for curr in number[1:]:
        # stack과 k가 0보다 크고, stack의 마지막 요소가 num보다 작을 경우 반복
        while len(stack) > 0 and k > 0 and stack[-1] < curr :
            k -= 1
            stack.pop()
        stack.append(curr)
    
    if k > 0 :
        stack = stack[:-k]
    return ''.join(stack)


    return answer