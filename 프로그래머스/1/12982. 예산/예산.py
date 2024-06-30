'''
1. 신청금액(d)을 정렬하고
2. 현재 예산에서 빼주기
'''
def solution(d, budget):
    answer = 0
    
    d.sort()
    
    for i in range(len(d)):
        if(budget >= d[i]):
            budget -= d[i]
            answer += 1
    
    return answer