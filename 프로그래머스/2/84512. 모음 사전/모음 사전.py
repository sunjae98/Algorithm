'''
단어 길이가 5이므로 각 자리에 가중치를 부여
각 자리의 증가량을 정의
'''

def solution(word):
    vowels = {'A': 0, 'E': 1, 'I': 2, 'O': 3, 'U': 4}
    weights = [781, 156, 31, 6, 1]  # 5^4, 5^3, 5^2, 5^1, 5^0
    
    answer = 0
    for i, char in enumerate(word):
        answer += weights[i] * vowels[char] + 1  
    
    return answer
