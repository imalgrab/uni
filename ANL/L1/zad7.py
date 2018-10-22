import math

def calka(n):
    if (n == 0):
        return math.log(6.0 / 5.0)
    return float(1.0 / n - 5.0 * calka(n - 1))

#for i in range(21):
 #   print(i, calka(i))


print(calka(20) + 5*calka(19))

