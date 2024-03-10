'''
result는 k + @
sol)정렬을 하고 앞에서 k만큼 무적권을 사용할 라운드를 기록
-> 사용하기로한 라운드가 뒤쪽에 있다면 무적권을 사용못하고 라운드가 끝남   

우선순위 큐 -> 최대 힙
여태 나온 값 중 가장 큰 값을 제거
'''
import heapq

def solution(n, k, enemy):
    enemy_sum = 0 
    heap = [] # 각 라운드 병사수를 힙으로 저장

    # 모든 적에 대해 반복합니다.
    for i in range(len(enemy)):
        enemy_sum += enemy[i]
        heapq.heappush(heap, -enemy[i])  # 파이썬 힙모듈은 최소힙을 제공 -> 음수를 붙여 최대힙으로 변경

        if enemy_sum > n:
            # 무적권이 없으면 이전 라운드 리턴
            if k == 0:
                return i
            # 무적권 감소시키고, 병사수가 가장 많은 라운드제거
            k -= 1
            enemy_sum += heapq.heappop(heap)
    
    # 해당 라운드 리턴
    return i + 1
