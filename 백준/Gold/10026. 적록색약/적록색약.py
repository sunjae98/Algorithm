'''
[bfs]
적록색약이 아닌경우 R != G
적록색약인경우 R == G 

먼저 적록색양인 어난 경우를 구현하고 추후 적록색약 조건을 추가

1. 0,0 부터 BFS 시작
2. 4방향으로 탐색
3. 탐색한 곳이 기점과 같다면 방문
4. 테이블을 순회하며 방문이 안된 곳이면 bfs시작, count++
'''
import sys
from collections import deque

answer = []

N = int(sys.stdin.readline().strip()) 
grid = []
for _ in range(N):
    grid.append(list(sys.stdin.readline().strip()))

# 이동할 네 가지 방향 (상, 하, 좌, 우)
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

q = deque()

# 방문 배열 초기화
visited = [[0 for _ in range(N)] for _ in range(N)]

def bfs(r, c):
    q.append((r, c))
    visited[r][c] = 1

    while q:
        r, c = q.popleft()
        # 네 방향으로 이동하며 탐색
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            # 1.범위 2.같은 그림 3.방문하지 않은 곳
            if 0 <= nr < N and 0 <= nc < N and grid[r][c] == grid[nr][nc] and visited[nr][nc] == 0:
                q.append((nr, nc)) # 큐에 추가
                visited[nr][nc] = 1

def bfs_blind(r, c):
    q.append((r, c))
    visited[r][c] = 1

    while q:
        r, c = q.popleft()
        # 네 방향으로 이동하며 탐색
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            # 1.범위 2.같은 그림(R == G) 3.방문하지 않은 곳
            if 0 <= nr < N and 0 <= nc < N and (grid[r][c] == grid[nr][nc] or ((grid[r][c] == 'R' or grid[r][c] == 'G') and (grid[nr][nc] == 'R' or grid[nr][nc] == 'G'))) and visited[nr][nc] == 0:
                q.append((nr, nc)) # 큐에 추가
                visited[nr][nc] = 1                

count = 0
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(i, j)
            count += 1
answer.append(count)

# 방문 배열 초기화
visited = [[0 for _ in range(N)] for _ in range(N)]

count_blind = 0
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs_blind(i, j)
            count_blind += 1
answer.append(count_blind)

print(answer[0],answer[1])