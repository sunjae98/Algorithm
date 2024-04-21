'''
[완전 탐색]
s의 길이가 1000 이하여서 완전탐색을 시도해도 시간초과 우려가 적음
1개씩 ~ 전체길이 탐색하며 이전에 탐색했던 문자와 같으면 압축해준다.
'''

def solution(s):
    answer = []

    for i in range(1, len(s)+1):

        txt1 = s[:i] # 기준 텍스트
        count = 1
        temp = ''

        for j in range(i, len(s)+i, i):
            txt2 = s[j:j+i] # 비교 텍스트
            if txt1 == txt2: # 텍스트가 같으면 압축
                count += 1
            else:
                if count != 1:
                    temp += str(count) + txt1
                else:
                    temp += txt1

                txt1 = s[j:j+i] # 다음 텍스트로 기준 변경
                count = 1

        answer.append(len(temp)) # i개로 압축한 문자열의 길이를 저장

    return min(answer)


                

