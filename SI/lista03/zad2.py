from copy import copy


def parse(spec):
    size = spec[0].split()
    h = int(size[0])
    rows, cols = [], []
    for i in range(1, h+1):
        r = spec[i].split()
        row = list(map(int, r))
        rows.append(row)
    for j in range(h+1, len(spec)):
        c = spec[j].split()
        col = list(map(int, c))
        cols.append(col)
    return (rows, cols)


def draw(nonogram, n, m):
    drawing = ''
    for i in range(n):
        for j in range(m):
            if nonogram[i][j] == 1:
                drawing += '#'
            elif nonogram[i][j] == 0:
                drawing += '.'
        drawing += '\n'
    return drawing


def transpose(nonogram, i):
    col = []
    for j in range(len(nonogram)):
        col.append(nonogram[j][i])
    return col


def solved(nonogram, n, m):
    for i in range(n):
        for j in range(m):
            if nonogram[i][j] == ' ':
                return False
    return True


def check(rc, spec):
    rc = [0] + rc
    n = len(rc)
    m = len(spec)
    dp = [[False] * (m + 1) for _ in range(n)]
    dp[0][0] = True
    for i in range(n - 1):
        for j in range(m):
            if dp[i][j]:
                if rc[i + 1] != 1:
                    dp[i+1][j] = True
                block = i + spec[j]
                if j < m and block < n and rc[block] != 1 and 0 not in rc[i+1:block]:
                    dp[block][j+1] = True
    return dp[n-1][m-1]


def is_good_coloring(i, j, nonogram, rows, cols):
    return check(nonogram[i], rows[i]) and check(transpose(nonogram, j), cols[j])


def try_color(i, j, nonogram, rows, cols):
    if nonogram[i][j] == ' ':
        nonogram[i][j] = 1
        if is_good_coloring(i, j, nonogram, rows, cols):
            nonogram[i][j] = 0
            if is_good_coloring(i, j, nonogram, rows, cols):
                nonogram[i][j] = ' '
            else:
                nonogram[i][j] = 1
        else:
            nonogram[i][j] = 0


def unassigned(nonogram, n, m):
    for i in range(n):
        for j in range(m):
            if nonogram[i][j] == ' ':
                return (i, j)
    return False


def solve(nonogram, n, m, rows, cols):
    for i in range(n):
        for j in range(m):
            try_color(i, j, nonogram, rows, cols)
    return nonogram


def backtrack(nonogram, n, m, rows, cols):
    if solved(nonogram, n, m):
        return nonogram
    else:
        if unassigned(nonogram, n, m) != False:
            x, y = unassigned(nonogram, n, m)
            curr = solve(nonogram, n, m, rows, cols)
            for c in [0, 1]:
                curr[x][y] = c
                if is_good_coloring(x, y, curr, rows, cols):
                    backtrack(curr, n, m, rows, cols)


def start(data):
    rows, cols = parse(data)
    n, m = len(rows), len(cols)
    nonogram = [[' '] * m for _ in range(n)]
    return backtrack(nonogram, n, m, rows, cols)


with open('zad_input.txt') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')
nonogram = start(data)
result = draw(nonogram, len(nonogram), len(nonogram[0]))
out.write(result)
out.close()
