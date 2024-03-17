'''
[그리디]
(잘못된 접근)
가벼운 두 사람씩 보트에 태워보내기
1. 오름차순 정렬
2. 앞에서 하나씩 꺼내서 temp 에 담음
    (더해진 값이 limit를 초과하기 전까지)
3. 초과되면 answer++
---------------------------
(수정)
무거운 사람 + 가벼운 사람 조합으로 보트에 태워보내기
1. 오름차순 정렬
2. 양쪽 끝 사람의 무게 합이 limit를 초과하지 않으면 보트에 태워보냄
3. 초과하면 무거운 사람을 보냄
4. 혼자 남았을때는 혼자 태워 보냄
'''
from collections import deque


def solution(people, limit):
    answer = 0
    people.sort()
    people = deque(people) # 리스트를 덱으로 초기화 -> 시간복잡도차이(O(N)<O(1))

    while people:
        # 마지막 1명이 남음
        if len(people) == 1:
            answer += 1
            break
        
        # 2명을 보냄
        elif people[0] + people[-1] <= limit:
            answer += 1
            people.popleft()
            people.pop()

        # 1명을 보냄
        else:
            answer += 1
            people.pop()
    return answer