'''
[dp]
c1, c2, c3라는 가치를 가지는 동전들이 있다고 할 때
dp[n] : 
    dp[n-c1], dp[n-c2], dp[n-c3]
    셋 중에 가장 개수가 적은 경우를 택하고 하나의 동전의 개수만 더해주면 됨
'''

import sys

input = sys.stdin.readline
n, k = map(int, input().split())
coins = []
for _ in range(n):
    coins.append(int(input()))

dp = [10001] * (k+1)
dp[0] = 0

for c in coins:
    for i in range(c, k + 1): 
        dp[i] = min(dp[i], dp[i-c]+1)

# 목표값을 가진 동전들로 만들 수 없을 경우
if dp[k] == 10001:
   print(-1)
else:
   print(dp[k])
