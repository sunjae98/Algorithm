'''
[그래프, dfs]
1. 두 정점으로 인접 행렬 그래프를 구현
2. dfs 를 통해 연결된 그래프의 개수를 계산
'''
import sys
sys.setrecursionlimit(10**6)

N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]

# 그래프(인접 행렬)
for i in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (1 + N)
count = 0 

def dfs(start, depth):

    visited[start] = True

    for i in graph[start]:
        if not visited[i]:
            dfs(i, depth + 1)

# 그래프를 순회
for i in range(1, N + 1):
    if not visited[i]: 
        dfs(i, 0) 
        count += 1 

print(count)