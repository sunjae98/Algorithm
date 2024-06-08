'''
1. 각 패턴을 정의
2. answer 을 순회하며 패턴과 비교
'''

def solution(answers):
    ans = []

    # 수포자별 찍기 패턴
    pattern1 = [1, 2, 3, 4, 5]
    pattern2 = [2, 1, 2, 3, 2, 4, 2, 5]
    pattern3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    scores = [0, 0, 0]
    
    # 주어진 answers에 대해 각 수포자의 패턴으로 맞춘 수를 카운트
    for i, answer in enumerate(answers):
        if answer == pattern1[i % len(pattern1)]:
            scores[0] += 1
        if answer == pattern2[i % len(pattern2)]:
            scores[1] += 1
        if answer == pattern3[i % len(pattern3)]:
            scores[2] += 1
    
    max_score = max(scores)

    # 최다 득점자 찾기
    for i in range(len(scores)):
        if scores[i] == max_score:
            ans.append(i + 1)

    return ans