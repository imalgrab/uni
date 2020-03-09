import random


def opt_dist(l, d):
    ls = [1] * d + [0] * (len(l)-d)
    min_swaps = len(l)
    for _ in range(len(l) - d + 1):
        cnt = 0
        for j in range(len(l)):
            if l[j] != ls[j]:
                cnt += 1
        if cnt < min_swaps:
            min_swaps = cnt
        ls = [0] + ls[:-1]
    return min_swaps


def is_valid(row, val):
    cnt = 0
    for i in range(len(row)):
        if row[i] == 1 and cnt > 0 and row[i-1] == 0:
            return False
        if row[i] == 1:
            cnt += 1
    return cnt == val


def is_completed(spec, rows, cols):
    for i in range(7):
        if not is_valid(rows[i], spec[0][i]):
            return False
    for j in range(7):
        if not is_valid(cols[j], spec[1][j]):
            return False
    return True


def swap(i, j, rows, cols):
    if rows[i][j] == 1:
        rows[i][j] = 0
        cols[j][i] = 0
    else:
        rows[i][j] = 1
        cols[j][i] = 1


def printer(rows):
    res = ''
    for r in rows:
        for el in r:
            if el == 0:
                print('.', end='', sep='')
                res += '.'
            elif el == 1:
                print('#', end='', sep='')
                res += '#'
        res += '\n'
        print()
    return res

# lepiej losowac lub wierssz lub kolumne

def try_color(i, rows, cols):
    if i % 23 == 0:
        swap(random.randint(0, 6), random.randint(0, 6), rows, cols)
    else:
        r = random.randint(0, 6)
        while is_valid(rows[r], specs[0][r]):
            r = random.randint(0, 6)
        maxVal = -1
        maxInd = -1
        for j in range(7):
            before = opt_dist(cols[j], specs[1][j]) + \
                opt_dist(rows[r], specs[0][r])

            swap(r, j, rows, cols)

            after = opt_dist(cols[j], specs[1][j]) + \
                opt_dist(rows[r], specs[0][r])

            if before - after > maxVal:
                maxVal = before - after
                maxInd = j

            swap(r, j, rows, cols)
        swap(r, maxInd, rows, cols)


def solve(specs):
    rows = [[0 for i in range(7)] for _ in range(7)]
    cols = [[0 for i in range(7)] for _ in range(7)]
    n = 500
    i = 0
    while i < n:
        try_color(i, rows, cols)
        if is_completed(specs, rows, cols):
            res = printer(rows)
            print(i)
            return res
        if i == 499:
            print('i=499')
            rows = [[0 for i in range(7)] for _ in range(7)]
            cols = [[0 for i in range(7)] for _ in range(7)]
            i = 0
        i += 1


with open('zad5_input.txt', 'r') as f:
    data = f.read().split('\n')

out = open('zad5_output.txt', 'w')

rows = []
cols = []
for i in range(1, 8):
    rows.append(int(data[i]))
for i in range(8, 15):
    cols.append(int(data[i]))
specs = (rows, cols)
out.write(solve(specs))
out.close()
