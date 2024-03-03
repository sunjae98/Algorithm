'''
1. 순수도난 필터링
2. 순부여벌 필터링
3. 앞 뒤 번호가 맞으면 체육복을 빌려줌
'''

def solution(n, lost, reserve):
    answer = 0

    # set을 통한 필터링
    Losts = set(lost) - set(reserve)
    Reserves = set(reserve) - set(lost)

    for i in Reserves:
        if i-1 in Losts: # 앞
            Losts.remove(i-1) # 빌려줌
        elif i+1 in Losts: # 뒤
            Losts.remove(i+1) # 빌려줌
    
    answer = n - len(Losts)
    return answer