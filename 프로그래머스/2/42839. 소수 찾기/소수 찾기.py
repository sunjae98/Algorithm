'''
1. 순열로 수를 뽑음
2. 정수형 변환으로 맨 앞자리 0 제거
2. 같은 숫자가 있으므로 중복 제거
3. 소수판별
'''
from itertools import permutations

# 소수 판별
def isPrime(num):
    if num < 2:
        return False
    if num == 2:
        return True
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    unique_numbers = set()

    # 모든 길이에 대해 순열 생성 : nP1, nP2, ...
    for length in range(1, len(numbers) + 1):
        for perm in permutations(numbers, length):
            # 순열을 숫자로 변환
            num = int(''.join(perm))
            unique_numbers.add(num)

    # 중복 제거된 숫자들 중 소수인지 판별
    for num in unique_numbers:
        if isPrime(num):
            answer += 1

    return answer

