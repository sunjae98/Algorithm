'''
[BFS]
1. 그림이 있는곳부터 bfs 시작
2. 방문시 visited++, area++
3. 끊어져있다면 탐색하지않은(방문하지않은곳)부터 다시 bfs
'''
import sys
from collections import deque

row, col = map(int, sys.stdin.readline().strip().split())
maps = []
for _ in range(row):
    maps.append(list(map(int, sys.stdin.readline().strip().split())))

# 이동할 네 가지 방향 (상, 하, 좌, 우)
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

q = deque()

# 방문 배열 초기화
visited = [[0 for _ in range(col)] for _ in range(row)]

def bfs(r, c):
    area = 1
    q.append((r, c))
    visited[r][c] = 1

    while q:
        r, c = q.popleft()
        # 네 방향으로 이동하며 탐색
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            # 1.범위 2.그림 3.방문하지 않은 곳
            if 0 <= nr < row and 0 <= nc < col and maps[nr][nc] == 1 and visited[nr][nc] == 0:
                q.append((nr, nc)) # 큐에 추가
                area += 1
                visited[nr][nc] = 1

    return area

count = 0
max_area = 0
for i in range(row):
    for j in range(col):
        if maps[i][j] == 1 and visited[i][j] == 0:
            max_area = max(max_area , bfs(i,j))
            count += 1

print(count)
print(max_area)
