tab = [1.0, -(1.0 / 7.0), 0.0]

for i in range(0, 100):
    tab[2] = (13.0 / 7.0 * tab[1]) + 2.0 / 7.0 * tab[0]
    tab[0], tab[1] = tab[1], tab[2]
    print(i, tab[2])
