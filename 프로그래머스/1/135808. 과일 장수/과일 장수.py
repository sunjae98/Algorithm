'''
1. 내림차순 정렬
2. n+m번째(n>0) 인덱스 값을 answer 에 더해줌
'''

def solution(k, m, score):
    answer = 0
    score.sort(reverse=True) 
    
    for i in range(m-1, len(score), m):
        answer += score[i] * m

    return answer