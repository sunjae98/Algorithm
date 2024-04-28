'''
[dp]
0행에서 최대가 되는 값을 구하려면 대각선 왼쪽이 최대가 되는 값을 구해야함
'''
import sys

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n = int(input())
    table = [list(map(int, input().split())) for _ in range(2)]
    answer = 0

    # 초기화
    dp = [[0] * n for _ in range(2)]

    dp[0][0] = table[0][0]
    dp[1][0] = table[1][0]
    if n>1:
        dp[0][1] = table[0][1] + table[1][0]
        dp[1][1] = table[1][1] + table[0][0]

    #예외처리
    if n == 1:
        answer = max(dp[0][0], dp[1][0])
    
    if n == 2:
        answer = max(dp[0][1],  dp[1][1])

    for i in range(2, n):
        dp[0][i] = table[0][i] + max(dp[1][i-2], dp[1][i-1])
        dp[1][i] = table[1][i] + max(dp[0][i-2], dp[0][i-1])
    answer = max(dp[0][n-1], dp[1][n-1])

    print(answer)
