'''
[그래프, bfs]
1. 두 정점으로 인접 행렬 그래프를 구현
2. bfs를 돌며 vistied 배열에 거리 정보를 넣음
3. vistied 배열에서 최대거리를 구해 해당 값을 가진 요소의 개수를 출력
'''
from collections import deque


def solution(n, edge):
    answer = 0

    graph = [[] for _ in range(n+1)]

    for i in range(len(edge)):
        u = edge[i][0]
        v = edge[i][1]
        graph[u].append(v)
        graph[v].append(u)
    
    visited = [-1] * (n+1)

    # 1번 노드에서 bfs 시작
    q = deque()
    q.append(1)
    visited[1] = 0

    while q:
        node = q.popleft()

        for next in graph[node]:
            if visited[next] == -1: # 방문하지 않았다면
                visited[next] = visited[node]+1
                q.append(next)

    max_length = max(visited)
    answer = visited.count(max_length)


    return answer



