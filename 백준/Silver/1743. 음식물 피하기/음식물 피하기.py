'''
[bfs]
1. 테이블을 만들고
2. 음식물을 해당 좌표에 넣음
3. bfs 로 최대 넓이 구함
'''

from collections import deque
import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())

maps = [[0 for _ in range(M)] for _ in range(N)] 

for _ in range(K):
    r, c = map(int, input().split())
    maps[r-1][c-1] = 1

# 방문 배열
visited = [[0 for _ in range(M)] for _ in range(N)]

# 이동할 네 가지 방향 (상, 하, 좌, 우)
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
        

def bfs(r, c):
    area = 1
    q = deque()
    q.append((r, c))
    visited[r][c] = 1

    while q:
        r, c = q.popleft()

        # 네 방향으로 이동하며 탐색
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            # 1.범위 2.갈 수 있는 길 3.방문하지 않은 곳
            if 0 <= nr < N and 0 <= nc < M and maps[nr][nc] == 1 and visited[nr][nc] == 0:
                q.append((nr, nc)) 
                area += 1
                visited[nr][nc] = 1

    return area

max_area = 0

# 테이블을 순회하며 bfs
for i in range(N):
    for j in range(M):
        if maps[i][j] == 1 and visited[i][j] == 0:
            max_area = max(max_area , bfs(i,j))

print(max_area)