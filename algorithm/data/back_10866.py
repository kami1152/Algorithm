from collections import deque
import sys

d= deque()
N = int(input())

for i in range(N):
    M = sys.stdin.readline().rstrip().split()
    if(M[0] == "push_front"):
        d.appendleft(int(M[1]))
    elif(M[0] == "push_back"):
        d.append(int(M[1]))
    elif(M[0] == "pop_front"):
        if(len(d) <= 0):
            print(-1)
        else:
            print(d.popleft())
    elif(M[0]=="pop_back"):
        if(len(d)<=0):
            print(-1)
        else:
            print(d.pop())
    elif(M[0]=="size"):
        print(len(d))
    elif(M[0] == "empty"):
        if(len(d)<=0):
            print(1)
        else:
            print(0)    
    elif(M[0] == "front"):
        if(len(d)<=0):
            print(-1)
        else:
            print(d[0])
    elif(M[0]=="back"):
        if(len(d)<=0):
            print(-1)
        else:
            print(d[len(d)-1])
