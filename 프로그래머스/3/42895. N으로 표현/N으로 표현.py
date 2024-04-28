from itertools import product

def solution(N, number):
    S = [set() for _ in range(9)]

    if N == number:
        return 1
    else:
        S[1].add(N)

    for i in range(1,9):
        S[i].add(int(str(N)*i))
        # S[1] = {N}
        # S[2] = {NN}
        for j in range(1,i+1):
            for x,y in product(S[j],S[i-j]):
                S[i].update({x+y,x-y,x*y})
                if y != 0:
                    S[i].add(x//y)
        if number in S[i]:
            return i
    return -1