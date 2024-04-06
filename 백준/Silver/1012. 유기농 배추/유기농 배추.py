'''
[dfs]
익숙한 bfs 풀이말고 dfs 시도
'''
import sys
# 재귀한도설정
sys.setrecursionlimit(1000000)

dx = [0, 0, -1, 1] 
dy = [1, -1, 0, 0]

# dfs 정의
def dfs(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 1. 범위 안에 있고 2.배추
        if (0 <= nx < M) and (0 <= ny < N) and maps[ny][nx] == 1:
            # 방문 표시
            maps[ny][nx] = -1
            dfs(nx, ny)

T = int(sys.stdin.readline()) 

for _ in range(T):
    M, N, K = map(int,sys.stdin.readline().split())
    maps = [[0 for _ in range(M)] for _ in range(N)]  # N과 M의 위치 수정

    # 배추 table
    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().split()) 
        maps[Y][X] = 1 

    count = 0
    for a in range(M):
        for b in range(N):
            if maps[b][a] == 1:
                dfs(a, b)
                count += 1

    print(count)