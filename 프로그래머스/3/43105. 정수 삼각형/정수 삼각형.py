'''
[DP]
1. dp 테이블 생성
2. dp [i][j] 는 dp[i][j], dp[i][j+1]에 접근가능
3. 1열과 마지막열은 값이 고정
'''
def solution(triangle):
    answer = 0

    N = len(triangle)
    dp = [[0 for j in range(N)] for i in range(N)]
    dp[0][0] = triangle[0][0]

    for i in range(1, N):
        # 1열은 1열에서만 더해짐
        dp[i][0] = dp[i-1][0] + triangle[i][0]
        for j in range(1, len(triangle[i])):
            if j == i: # 마지막 열 
                dp[i][j] = dp[i-1][j-1] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
        answer = max(dp[-1])
    return answer