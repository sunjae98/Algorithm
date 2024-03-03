'''
1. 정점 찾기
    - 나가는 간선이 2개 이상
    - 들어오는 간선 없음
3. 도넛 : 재방문 정점 -> 나가는 간선이 1개
2. 막대 : 나가는 간선이 없는 정점 존재
3. 8자 : 나가는 간선이 2개 이상 존재
'''
from collections import defaultdict

def find_centroid(graph, inDegree, outDegree):
    # 중심 시작점
    for node in graph.keys():
        if inDegree[node] == 0 and outDegree[node] >= 2:
            return node

def count_graphs(centroid, graph, inDegree, outDegree):
    count = [0, 0, 0] # 도넛, 막대, 8자 모양
    visited = set()
    for start in graph[centroid]: # 중심 시작점이 갈 수 있는 모든 노드에 대해 탐색
        visited.add(start)
        curr = start
        while curr:
            if outDegree[curr] == 0: # 막대
                count[1] += 1
                break
            elif outDegree[curr] == 2: # 8자
                count[2] += 1
                break
            curr = graph[curr][0] # 다음으로 이동
            if curr in visited and outDegree[curr] == 1: # 도넛
                count[0] += 1
                break
            visited.add(curr)
    return [centroid] + count

def solution(edges):
    graph = defaultdict(list)
    inDegree = defaultdict(int) # 들어오는 간선
    outDegree = defaultdict(int) # 나가는 간선
    for start, end in edges:
        graph[start].append(end)
        inDegree[end] += 1
        outDegree[start] += 1

    centroid = find_centroid(graph, inDegree, outDegree)
    return count_graphs(centroid, graph, inDegree, outDegree)