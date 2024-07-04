'''
[스택]
1. goal 을 순회하며
2. 요소가 card1, card2 스택 peek 에 존재하는지 확인
3. 존재한다면 peek를 없애고 다음으로 넘어감
'''

def solution(cards1, cards2, goal):
    answer = "Yes"
    
    cards1.reverse()
    cards2.reverse()

    
    for i in range(len(goal)):
        # 1번 카드 뭉치 체크
        if((len(cards1) != 0) and (goal[i] == cards1[-1])):
            cards1.pop()
        # 2번 카드 뭉치 체크
        elif ((len(cards2) != 0) and (goal[i] == cards2[-1])):
            cards2.pop()
        else:
            answer = "No"
            break
            
    return answer
