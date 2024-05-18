'''
[dfs]
1. 장애물처리 -> T가 있는 좌표는 -1 로 초기화
2. 목적지에 k거리만큼 도착하는 경우에만 answer ++
'''
import sys
sys.setrecursionlimit(1000000)

R, C, K = map(int, input().split())

maps = [list(input().rstrip()) for _ in range(R)] 

# 장애물 처리
for row in range(len(maps)):
    for col in range(len(maps[row])):
        if maps[row][col] == 'T':
            maps[row][col] = -1
        else:
            maps[row][col] = 0

dr = [0, 0, -1, 1] 
dc = [1, -1, 0, 0]

def dfs(r, c, dis):
    global answer
    # 목적지도착, 이동거리가 K
    if r == 0 and c == C - 1 and dis == K:
        answer += 1
        return

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]

        # 1. 범위  2.장애물 X, 방문 X
        if (0 <= nr < R) and (0 <= nc < C) and maps[nr][nc] == 0:
            # 방문 표시
            maps[nr][nc] = 1
            dfs(nr, nc, dis + 1)
            maps[nr][nc] = 0 #초기화

answer = 0

# 시작점
maps[R-1][0] = 1 
dfs(R-1, 0, 1)

print(answer)