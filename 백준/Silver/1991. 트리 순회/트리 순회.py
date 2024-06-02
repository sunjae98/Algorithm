'''
[tree]
전위 순회, 중위 순회, 후위 순회
-> 각각의 함수를 작성
'''
import sys


input = sys.stdin.readline

N = int(input())
tree = {}

for _ in range(N):
    root, left, right = map(str, input().split())
    tree[root] = [left, right]

# tree : {'A': ['B', 'C'], 'B': ['D', '.'], 'C': ['E', 'F'], 'E': ['.', '.'], 'F': ['.', 'G'], 'D': ['.', '.'], 'G': ['.', '.']}
# key value 형태 

# 전위순회 : 루트 -> 왼 -> 오
def preorder(root):
    if root != '.':
        print(root, end='') 
        preorder(tree[root][0])  
        preorder(tree[root][1]) 
 

# 중위순회 : 왼 -> 루트 -> 오 
def inorder(root):
    if root != '.':
        inorder(tree[root][0])  
        print(root, end='')  
        inorder(tree[root][1])  
 
# 후위순회 : 왼 -> 오 -> 루트
def postorder(root):
    if root != '.':
        postorder(tree[root][0])  
        postorder(tree[root][1]) 
        print(root, end='')

# 출력형식
preorder('A')
print()
inorder('A')
print()
postorder('A')