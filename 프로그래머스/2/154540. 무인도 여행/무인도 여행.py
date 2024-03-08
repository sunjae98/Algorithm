from collections import deque

def solution(maps):
    answer = []

    row = len(maps)
    col = len(maps[0])

    # 이동할 네 가지 방향
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    # 방문 배열
    visited = [[False for _ in range(col)] for _ in range(row)]

    def dfs(r, c):
        stack = deque([(r, c)])
        visited[r][c] = True
        total_sum = 0

        while stack:
            r, c = stack.pop()
            total_sum += int(maps[r][c]) # 현 위치 식량

            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if 0 <= nr < row and 0 <= nc < col and maps[nr][nc] != 'X' and not visited[nr][nc]:
                    stack.append((nr, nc))
                    visited[nr][nc] = True

        return total_sum

    # maps 순회
    for i in range(row):
        for j in range(col):
            if maps[i][j] != 'X' and not visited[i][j]:
                days = dfs(i, j)
                if days > 0:  # 무인도가 존재
                    answer.append(days)

    if not answer:
        return [-1]
    else:
        answer.sort()
        return answer
