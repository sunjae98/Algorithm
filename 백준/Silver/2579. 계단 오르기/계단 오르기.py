'''
[dp]
1. bottom-up 방식
2. dp 점화식 작성
3. 최댓값 반환
'''
import sys

input = sys.stdin.readline

N = int(input())

stairs = [0] * 300
for i in range(N):
    stairs[i] = int(input())

dp = [0] * 300

# dp 배열 초기값
dp[0] = stairs[0]
dp[1] = stairs[0] + stairs[1]
dp[2] = stairs[2] + max(stairs[0], stairs[1])

# 반복문을 통한 점화식 계산
for i in range(3, N):
    dp[i] = stairs[i] + max(stairs[i-1] + dp[i-3], dp[i-2]) 

# 마지막 계단
ans = dp[N-1]

print(ans)