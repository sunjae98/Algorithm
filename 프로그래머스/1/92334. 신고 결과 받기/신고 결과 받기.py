'''
1. A가 B를 여러번 신고해도 의미 없으므로 중복 제거
2. key : value 저장
    2-1.유저 : 신고받은 회수
    2-2.유저 : 신고한 유저 리스트
3. 2-2 의 요소를 순차적으로 탐색하며 2-1 의 value >= K 확인
'''
from collections import defaultdict


def solution(id_list, report, k):
    answer = []

    report = set(report) # 중복 제거
    report_cnt = defaultdict(int) # 신고 횟수
    report_list = defaultdict(list) # 신고 리스트

    # 유저(key), (회수,리스트)value 매핑
    for i in report:
        a, b = i.split()
        report_list[a].append(b)
        report_cnt[b] += 1

    # 전체 유저 목록
    for id in id_list:
        result = 0
        for i in report_list[id]:
            if report_cnt[i] >= k:
                result += 1
        
        answer.append(result)

    return answer