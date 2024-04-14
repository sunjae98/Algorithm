def comparison(x, y):
    if x == '1' or y == '1':
        return '#'
    else:
        return ' '

def solution(n, arr1, arr2):
    answer = []
    
    map_1 = []
    map_2 = []
    
    # 이진수로 변환하여 지도 1에 저장
    for num in arr1:
        binary1 = bin(num)[2:].zfill(n) # 슬라이싱으로 0b 접두사를 제외
        map_1.append(list(binary1))
    
    # 이진수로 변환하여 지도 2에 저장
    for num in arr2:
        binary2 = bin(num)[2:].zfill(n)
        map_2.append(list(binary2))
    
    for i in range(n):
        code = ''
        for j in range(n):
            code += comparison(map_1[i][j], map_2[i][j])
        answer.append(code)

    return answer
    

