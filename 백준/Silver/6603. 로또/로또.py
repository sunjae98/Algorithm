import sys
from itertools import combinations

input = sys.stdin.readline  # input 재정의
first_case = True

while True:
    S = list(map(int, input().split()))
    k = S[0]

    if k == 0:
        break

    S = S[1:]  # S 정의 수정: 첫 원소는 k 이므로 제외

    if not first_case:
        print()  # 첫 테스트 케이스가 아닌 경우에만 줄바꿈 출력

    for comb in combinations(S, 6):
        print(' '.join(map(str, comb)))  # 이미 정렬된 상태의 출력

    first_case = False  # 첫 테스트 케이스가 아님을 표시
