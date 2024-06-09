'''
명함의 가로 < 세로 인 경우 두 값을 바꿔줌
answer = 명함들의 가로 최대 값 * 명함들의 세로 최대 값
'''

def solution(sizes):
    max_width = 0
    max_height = 0
    
    for w, h in sizes:
        # 가로와 세로 중 더 큰 값을 세로로 고정
        if w < h:
            w, h = h, w
        
        max_width = max(max_width, w)
        max_height = max(max_height, h)

    answer = max_width * max_height
    return answer