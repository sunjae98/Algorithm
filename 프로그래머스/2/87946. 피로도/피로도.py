'''
1. 순열로 던전 순서를 생성
2. 생성한 던전을 탐험
3. 탐헌한 던전 개수를 리턴
'''

from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    # 던전 순서 생성
    for dungeon_list in permutations(dungeons):
        fatigue_now = k  # 피로도 초기화
        count = 0 
        
        # 던전 탐험
        for need, consum in dungeon_list:
            if fatigue_now >= need:
                fatigue_now -= consum
                count += 1
            else:
                break 
        
        # 최대 탐험 가능 던전 수 갱신
        answer = max(answer, count)
    
    return answer
