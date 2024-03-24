import sys

# 입력 받기
N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

max_height = max(arr)  # 가장 큰 나무 찾기
min_height = 0
result = 0

# 이분 탐색
while min_height <= max_height:
    mid = (max_height + min_height) // 2
    wood_sum = 0

    # 나무 절단
    for height in arr:
        if height > mid:
            wood_sum += height - mid

    # 나무의 합이 목표보다 크면 높이를 높여야 함
    if wood_sum >= M:
        result = mid
        min_height = mid + 1
    # 나무의 합이 목표보다 작으면 높이를 낮춰야 함
    else:
        max_height = mid - 1

print(result)
