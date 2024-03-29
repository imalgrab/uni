import random


def opt_dist(l, d):
    s = [0]
    for i in range(len(l)):
        s.append(s[i] + l[i])
    res = len(l)
    for i in range(len(l) - d + 1):
        left = i
        right = i + d - 1
        before = s[left]  # suma jedynek w (0, l-1)
        curr = s[right+1] - s[left]  # suma jedynek w (l, r)
        after = s[len(l)] - s[right+1]  # suma jedynek w (r+1, n-1)
        res = min(res, before + after + d - curr)
    return res


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


def try_color(i, rows, cols):
    if i % 63 == 0:
        swap(random.randint(0, 6), random.randint(0, 6), rows, cols)
    else:
        f = random.randint(0, 1)
        maxVal = -1
        maxInd = -1
        r = random.randint(0, 6)
        if f:
            while(is_valid(rows, specs[0][r])):
                r = random.randint(0, 6)
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
        else:
            while(is_valid(cols, specs[1][r])):
                r = random.randint(0, 6)
            for j in range(7):
                before = opt_dist(cols[r], specs[1][r]) + \
                    opt_dist(rows[j], specs[0][j])
                swap(j, r, rows, cols)
                after = opt_dist(cols[r], specs[1][r]) + \
                    opt_dist(rows[j], specs[0][j])
                if before - after > maxVal:
                    maxVal = before - after
                    maxInd = j
                swap(j, r, rows, cols)
            swap(maxInd, r, rows, cols)


def solve(specs):
    prev = specs
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
            rows = [[0 for i in range(7)] for _ in range(7)]
            cols = [[0 for i in range(7)] for _ in range(7)]
            specs = prev
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
