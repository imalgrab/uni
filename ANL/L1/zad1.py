import math

def solve(a, b, c):
    delta = (b*b - 4*a*c)
    x1 = (-b - math.sqrt(delta)) / 2*a
    x2 = (-b + math.sqrt(delta)) / 2*a
    return x1, x2

def check(x1, x2, a, b, c):
    return a*(x1**2) + b*x1 + c
a = input()
b = input()
c = input()


x1 = solve(a, b, c)[0]
x2 = solve(a, b, c)[1]


#1

test(1000, 1000, 1)

#2

test(0.0000001, 0.01, 0.0000001)


#3

test(1, 20000000000, 100)

#4

test(0.00001, 1, 0.00001)



