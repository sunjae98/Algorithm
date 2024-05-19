'''
---
dfs를 사용할때 visited 배열이 필수적인게 아니였음
거꾸로 생각하는 사고를 항상 생각하자
    T -> S 가 가능한가 ?
    규칙1) 마지막 문자가 A -> A를 제거
    규칙2) 마지막 문자가 B -> B를 제거 + 문자열을 뒤집음
'''
import sys

S=list(input())
T=list(input())

def dfs(str):
    global answer
    if str == S:
        answer = 1
    if len(str) == 0:
        return
    if str[-1] == "A": # 규칙1
        dfs(str[:-1])
    if str[0] == "B": # 규칙2
        dfs(str[1:][::-1])

answer = 0
dfs(T)
print(answer)