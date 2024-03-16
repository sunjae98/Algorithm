'''
1. board 에서 moves 값에 따라 해당 열을 위에서 부터 탐색
2. 0이 아닌 값이 나오면 해당 값을 stack에 넣음
3. peek를 보고 같은 값이 나오면 터뜨림
'''
def solution(board, moves):
    answer = 0
    row = len(board)
    col = len(board[0])
    stack = [] # 파이썬에서 list는 stack과 유사

    for c in moves:
        for r in range(0, row):
            doll = board[r][c-1]
            if(doll != 0):
                board[r][c-1] = 0
                # 스택 peek 와 같다면
                if(len(stack) != 0 and stack[-1] == doll):
                    stack.pop()
                    answer += 2
                else:
                    stack.append(doll)
                break
            
    return answer
