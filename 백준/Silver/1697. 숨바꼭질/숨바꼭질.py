'''
1. x번 전진 (X = X + 1)
2. y번 후진 (X = X - 1)
3. z번 순간이동 (X = X * 2)

3가지 경우를 bfs 로 탐색
'''
import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
visited = [0] * 100001

def bfs(x):
    q = deque()
    q.append(x)
    while q:
        x = q.popleft()
        if x == K:
            return visited[x]
        for nx in (x+1, x-1, x*2):
            if 0 <= nx < 100001 and not visited[nx]:
                visited[nx] = visited[x] + 1
                q.append(nx)

print(bfs(N))

