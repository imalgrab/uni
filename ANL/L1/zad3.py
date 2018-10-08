import math

def sum(k):
    s = 0.0
    for i in range(k + 1):
        s += (-1) ** i / (2 * i + 1)
    return 4 * s

res = 0.0
i = 0

while (abs(4 * res - math.pi) > 10 ** (-5)):
    res += (-1) ** i / (2 * i + 1)
    i += 1
print(i)
    
