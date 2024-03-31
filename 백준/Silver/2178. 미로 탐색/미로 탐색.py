'''
[BFS]
1. 2차원 배열 visited 를 생성해서 0으로 초기화
2. BFS -> 방문시 visited[i][j] 값 증가
3. visited[row-1][col-1] 값에 따라 answer 설정
'''
import sys
from collections import deque

row, col = map(int, sys.stdin.readline().split())
maps = []
for _ in range(row):
    maps.append(list(map(int, sys.stdin.readline().rstrip())))


def bfs(r, c):
    answer = 0
    
    # 방문 배열 초기화
    visited = [[0 for _ in range(col)] for _ in range(row)]
    
    # 이동할 네 가지 방향 (상, 하, 좌, 우)
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    # r,c 에서 bfs 시작
    q = deque()
    q.append((r, c))
    visited[r][c] = 1
    
    while q:
        r, c = q.popleft()
        
        # 목적지
        if r == row - 1 and c == col - 1:
             answer = visited[r][c]
             break
        
        # 네 방향으로 이동하며 탐색
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            # 1.범위 2.갈 수 있는 길 3.방문하지 않은 곳
            if 0 <= nr < row and 0 <= nc < col and maps[nr][nc] == 1 and visited[nr][nc] == 0:
                q.append((nr, nc)) # 큐에 추가
                visited[nr][nc] = visited[r][c] + 1
    
    return answer

print(bfs(0,0))