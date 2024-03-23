'''
1트
list.remove()로 1231 그룹화해서 result++
이렇게 간단할까..??
-----
2트
문제를 잘못읽음 연속으로 1231이 와야 쌓을수 있다. -> [stack]
=> 위에서 빵 야채 고기가 내려오는 테트리스 같은 느낌..?
'''
def solution(ingredient):
    answer = 0
    stack = []
    
    # 재료를 하나씩 스택에 쌓음
    for curr in ingredient:
        # 빵이 나타나고 3겹 이상 쌓인경우에 -> 스택의 최상단 3개가 고기, 야채, 빵이라면
        if(curr == 1 and len(stack) >= 3 and stack[-1] == 3 and stack[-2] == 2 and stack[-3] == 1):
            # 3개 없애줌
            for i in range(3):
                stack.pop()
            answer += 1
        else:
            stack.append(curr) # 재료를 스택에 쌓아줌
            
    return answer
