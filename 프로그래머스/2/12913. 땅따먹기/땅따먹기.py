'''
[dp : bottom-up]
두 행씩 탐색하며 열이 중복되지 않는 최대값을 더해나가기
'''
def solution(land):
    answer = 0

    # 초기화 ([[0,0,0,0],[0,0,0,0]...])
    dp = [[0] * 4 for _ in range(len(land))]

    # 기저 상태
    for i in range(4):
        dp[0][i] = land[0][i]

    for k in range(1, len(land)):
        for i in range(4):
            for j in range(4):
                # 중복되지 않는 열
                if i != j:
                    dp[k][i] = max(dp[k][i], land[k][i] + dp[k - 1][j])

    answer = max(dp[len(land)-1])

    return answer