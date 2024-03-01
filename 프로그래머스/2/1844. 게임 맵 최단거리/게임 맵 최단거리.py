'''
[BFS]
1. 2차원 배열 visited 를 생성해서 0으로 초기화
2. BFS -> 방문시 visited[i][j] 값 증가
3. visited[row-1][col-1] 값에 따라 answer 설정
'''
from collections import deque

def solution(maps):
    answer = -1
    row = len(maps)
    col = len(maps[0])
    
    # 방문 배열 초기화
    visited = [[0 for j in range(col)] for i in range(row)]
    
    # 이동할 네 가지 방향 (상, 하, 좌, 우)
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    # (0,0)에서 bfs 시작
    q = deque()
    q.append((0, 0))
    visited[0][0] = 1
    
    while q:
        x, y = q.popleft()
        
        # 목적지
        if x == row - 1 and y == col - 1:
             answer = visited[x][y]
             break
        
        # 네 방향으로 이동하며 탐색
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            # 1.범위 2.갈 수 있는 길 3.방문하지 않은 곳
            if 0 <= nx < row and 0 <= ny < col and maps[nx][ny] == 1 and visited[nx][ny] == 0:
                q.append((nx, ny)) # 큐에 추가
                visited[nx][ny] = visited[x][y] + 1
    
    # 도착 지점까지 도달할 수 없는 경우
    if visited[row-1][col-1] == 0:
        return -1
    else:
        return answer
