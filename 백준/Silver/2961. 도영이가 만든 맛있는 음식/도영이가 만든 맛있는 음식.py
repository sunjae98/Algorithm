'''
[조합 + 완전탐색]
조합으로 모든 경우의수 돌림 -> 최솟값
'''

import sys
from itertools import combinations


input = sys.stdin.readline
N = int(input())

Taste = []
ans = sys.maxsize

for _ in range(N):
    S, B = map(int, input().split())
    Taste.append([S,B])

# i개를 뽑음
for i in range(1, N+1):
    Comb = list(combinations(Taste, i))
    for c in Comb:
        sour = 1
        bitter = 0
        for ingredient in c:
            sour *= ingredient[0]
            bitter += ingredient[1]
         
        ans = min(ans, abs(sour - bitter)) # 차이의 최솟값을 저장

print(ans)