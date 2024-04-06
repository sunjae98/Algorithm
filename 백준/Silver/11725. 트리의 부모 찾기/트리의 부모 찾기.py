'''
트리 자료구조에 익숙하지 않아 감이 안왔던 문제
풀이를 참고하니 bfs로 해결가능
'''
import sys
from collections import deque

N = int(sys.stdin.readline().strip()) 

# dict를 활용해 그래프 형식으로 저장
tree = dict()
for i in range(1,N+1):
	tree[i] = []
for _ in range(N-1):
	n1,n2 = map(int,sys.stdin.readline().split())
	tree[n1].append(n2)
	tree[n2].append(n1)

def bfs(N,tree):
	# 루트노드를 처음으로 탐색
	q = deque([1])
	parent = [0] * (N+1)
	
	while q:
		# 큐에서 꺼낸 노드와 연결되있는 노드를 방문
		now = q.popleft()
		for i in tree[now]:
			# parent가 갱신되어 있지 않으면 부모노드
			if parent[i] == 0 and i != 1:
				parent[i] = now
				q.append(i)
				
	# 2번 노드 부터 부모노드를 출력			
	for i in range(2,N+1):
		print(parent[i])
		
bfs(N,tree)