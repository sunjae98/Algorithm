'''
가격이 낮은 사과들을 최대한 묶어
정렬하고 m배수로 인덱스 끊어서 제일 앞 인덱스로 계ㅅ산
'''
def solution(k, m, score):
    answer = 0
    
    score.sort()
    score.reverse()
    
    for i in range(m - 1 , len(score), m):
        if(i < len(score)):
            answer += score[i] * m
    

    return answer