def solution(friends, gifts):
    answer = 0

    # 친구 이름과 인덱스를 매핑
    friend_map = {}
    for i in range(len(friends)):
        friend_map[friends[i]] = i
    
    # 받은 선물 개수
    index = [0] * len(friends)

    # 선물 지수 테이블
    record = [[0] * len(friends) for _ in range(len(friends))]

    # 선물 교환 기록을 확인하며 횟수 계산
    for gift in gifts:
        trade = gift.split(" ")
        A = trade[0]
        B = trade[1]

        index[friend_map[A]] += 1
        index[friend_map[B]] -= 1
        record[friend_map[A]][friend_map[B]] += 1

    # 가장 많이 선물 받은 친구 찾기
    for i in range(len(friends)):
        cnt = 0
        for j in range(len(friends)):
            if i == j:
                continue
            # 1.선물 지수가 높음
            # 2.선물 지수가 같음 + 받은 선물의 개수가 더 많은 경우 카운트 증가
            if record[i][j] > record[j][i] or (record[i][j] == record[j][i] and index[i] > index[j]):
                cnt += 1
        # 최대값 저장
        answer = max(cnt, answer)
    
    return answer
