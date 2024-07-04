def solution(seoul):
    answer = ''
    
    count = -1
    
    for i in range(len(seoul)):
        count += 1
        if(seoul[i] == "Kim"):
            break   
    
    answer = f"김서방은 {count}에 있다"
    
    return answer