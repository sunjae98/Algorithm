import sys

# 지방의 수 입력
N = int(input())
# 각 지방의 예산 요청을 저장할 리스트
arr = list(map(int, input().split()))

# 지방의 예산 요청을 오름차순 정렬
arr.sort()

# 가장 적은 예산 요청
min_budget = 0
# 가장 높은 예산 요청
max_budget = arr[-1]
# 중간값
mid_budget = 0

# 총 예산 입력
budget = int(input())

while min_budget <= max_budget:
    # 특정한 정수 상한액
    mid_budget = (min_budget + max_budget) // 2
    # 각 예산의 합
    total = 0
    
    for i in range(N):
        # 지방의 예산 요청이 상한액 이하라면
        if arr[i] <= mid_budget:
            total += arr[i]  # 합계에 지방의 예산 요청을 저장
        else:
            total += mid_budget  # 초과한다면 합계에 상한액을 저장
    
    if total > budget:  # 예산을 초과하면
        max_budget = mid_budget - 1  # 최댓값을 줄여줌
    else:  # 예산보다 모자르면
        min_budget = mid_budget + 1  # 최솟값을 늘려줌

# 결과값 출력
print(max_budget)
