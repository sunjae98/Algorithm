def solution(m, n, puddles):
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[1][1] = 1  # 시작 지점

    # 물웅덩이 초기화
    for x, y in puddles:
        dp[y][x] = -1

    for y in range(1, n + 1):
        for x in range(1, m + 1):
            if y == 1 and x == 1:
                continue
            if dp[y][x] == -1:
                dp[y][x] = 0
            else:
                left = dp[y][x - 1] if x > 1 else 0
                up = dp[y - 1][x] if y > 1 else 0
                dp[y][x] = (left + up) % 1000000007

    return dp[n][m]