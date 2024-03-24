'''
이분탐색으로 공유기 사이의 거리를 줄이고 늘리면서 C개를 채울 수 있는지 확인
'''
import sys

N, C = map(int, sys.stdin.readline().split())

routers = []
for _ in range(N):
    routers.append(int(sys.stdin.readline()))

routers.sort()

start = 1
end = routers[-1] - routers[0]

while(start <= end):
    distance = (start + end) // 2

    # 공유기가 몇대 설치가능한지 ?
    curr = routers[0]
    count = 1
    for i in range(1, len(routers)):
        if routers[i] >= curr + distance:
            count += 1
            curr = routers[i]
    
    if count >= C:
        start = distance + 1
        answer = distance
    else:
        end = distance - 1

print(answer)