'''
[dp]
'''
import sys

input = sys.stdin.readline
N, K = map(int, input().split())
knapsack = [list(map(int, input().split())) for _ in range(N)]

dp = [[0]*(K+1) for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,K+1):
        if j >= knapsack[i-1][0]:  # 현재최대무게 j가 해당물건무게보다 큰 경우
            curr_v = knapsack[i-1][1]
            prev_v = dp[i-1][j-knapsack[i-1][0]]
            dp[i][j] = max(dp[i-1][j], prev_v + curr_v)
        else:
        	# 현재최대무게 j가 해당물건무게보다 작은 경우 (현재 물건을 담을 수 없는 경우)
            dp[i][j] = dp[i-1][j]

print(dp[N][K]) 

