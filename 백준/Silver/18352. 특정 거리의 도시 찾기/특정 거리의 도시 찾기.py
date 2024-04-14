'''
[그래프 ,bfs]
1. 두 정점으로 인접 행렬 그래프를 구현
2. bfs를 돌며 vistied 배열에 거리 정보를 넣음
'''

import sys
from collections import deque

# N 도시 수, M 도로 수, K 거리 정보 X 출발 도시
N, M, K, X = map(int, sys.stdin.readline().split(' '))
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v =  map(int, sys.stdin.readline().split(' '))  
    graph[u].append(v)

visited = [-1] * (N+1)

# X 에서 bfs 시작
q = deque()
q.append(X)
visited[X] = 0

while q:
    city = q.popleft()

    for next in graph[city]:
        if visited[next] == -1: # 방문하지 않았다면
            visited[next] = visited[city]+1
            q.append(next)

#  최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력
if K in visited:
    for i in range(1, N+1):
        if visited[i] == K:
            print(i)
# 최단 거리가 K인 도시가 하나도 존재하지 않음            
else:
    print(-1)