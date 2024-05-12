'''
1 : 1.5 : 2 비율이니까
>> 1 : 1
>> 1 : 1.5
>> 1 : 2
>> 1.5 : 2
4가지 경우의 쌍을 찾기
'''
from collections import Counter
import math

def solution(weights):
    answer = 0

    counter = Counter(weights) # Counter({100: 2, 180: 1, 360: 1, 270: 1})
    dict = counter.items() # dict_items([(100, 2), (180, 1), (360, 1), (270, 1)])

    # 같은숫자가 2개 이상인 경우
    for key,value in dict:
        if value >= 2:
            answer += math.comb(value, 2) # nC2
            
    # 중복 제거
    weights = set(weights)

    for w in weights:
        if w * 2/3 in weights:
            answer += counter[w * 2/3] * counter[w]
        if w * 2/4 in weights:
            answer += counter[w * 2/4] * counter[w]
        if w * 3/4 in weights:
            answer += counter[w * 3/4] * counter[w]

    return answer