def solution(a, b, n):
    answer = 0
    now = n

    
    while now >= a:
        k = (now // a) * b # 몫
        mod = now % a # 나머지

        answer += k
        now = mod + k

        
    return answer