import math

def solve(a, b, c):
    delta = (b*b - 4*a*c)
    x1 = (-b - math.sqrt(delta)) / 2*a
    x2 = (-b + math.sqrt(delta)) / 2*a
    return x1, x2

def check(x1, x2, a, b, c):
    return a*(x1**2) + b*x1 + c, a*(x2**2) + b*x2 + c

def test(a, b, c):
    a = float(a)
    b = float(b)
    c = float(c)
    print("x1, x2 :", solve(a, b, c))
    print("check :", check(solve(a, b, c)[0], solve(a, b, c)[1], a, b, c))
    print()


#1

test(1000, 1000, 1)
test(1, 1000, 1000)

#2

test(0.0000001, 0.01, 0.0000001)


#3

test(1, 20000000000, 100)

