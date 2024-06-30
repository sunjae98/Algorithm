'''
name : yearning -> dictionory 형태로 변환
'''
def solution(name, yearning, photo):
    answer = []
    answer = [0] * len(photo)
    
    dict = {}
    
    for i in range(len(name)):
        key = name[i]
        value = yearning[i]
        dict[key] = value

    for i in range(len(photo)):
        for j in range(len(photo[i])):
            person = photo[i][j]
            if person in dict: # dict 에 key 가 있는지 확인
                answer[i] += dict[person]

    return answer