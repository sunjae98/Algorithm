import sys

N = int(sys.stdin.readline().rstrip())
road = list(map(int, sys.stdin.readline().split()))
city = list(map(int, sys.stdin.readline().split()))
rest_road = 0;
answer = 0;

city.pop()
min_city = min(city) 

for i in range(0, N-1):
    if(city[i] != min_city):
        cost = city[i] * road[i]
        answer += cost
    else:
        rest_road = sum(road[i:])  # 남은 도로의 비용 계산
        cost = min_city * rest_road
        answer += cost
        break

print(answer)