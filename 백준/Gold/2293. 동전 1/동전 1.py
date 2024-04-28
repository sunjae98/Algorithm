'''
[dp]
top-down
10원을 만들기 위해서 5원을 만드는 경우를 구해줌
5원을 만들기 위해서 2원을 만드는 경우를 구해줌
2원을 만들기위해서 1원을 만드는 경우를 구해줌
'''

import sys

input = sys.stdin.readline
n, k = map(int, input().split())
cost = []
for _ in range(n):
    cost.append(int(input()))

dp = [0] * (k+1)
dp[0] = 1

for c in cost:
    for i in range(c, k + 1): 
        # (c)원 부터 dp 갱신
        dp[i] = dp[i] + dp[i - c]

print(dp[k])