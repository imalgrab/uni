import math

def pow(x, n):
    res = 1.0
    for i in range(0, n):
        res *= x
    return res

def fact(n):
    if (n == 0):
        return 1.0
    else:
        return n * fact(n-1)

def sin(x, n):
    res = 0.0
    for i in range(n):
        res += pow(-1, i) * pow(x, 2 * i + 1) / fact(2 * i + 1)
    return res

print(sin(math.pi / 6, 5))

print(math.sin(math.pi / 6))


def sinFrac(x, k):
    def aux(a, b, i):
        if (i > k):
            return 0.0
        return a*b*x*x / a*b - x*x + aux(a+1, b+2, i+1)
    return x / (1 + aux(1, 1, 1))

print(sinFrac(math.pi / 2, 5))
        
        
    
    
        
