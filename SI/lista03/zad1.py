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
    rc = [0] + rc + [0]
    n = len(rc)
    m = len(spec)
    dp = [[False] * (m + 1) for _ in range(n + 1)]
    dp[0][0] = True

    for i in range(n-1):
        for j in range(m + 1):
            if dp[i][j]:

                # 1. idziemy o 0 blokow
                if rc[i + 1] != 1:
                    dp[i+1][j] = True

                # 2. idziemy o 1 blok
                if j < m and i+spec[j]+1 < n and rc[i+spec[j]+1] != 1 and 0 not in rc[i+1:i+spec[j]+1]:
                    dp[i+spec[j]+1][j+1] = True

    return dp[n-1][m]


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


def solve(data):
    rows, cols = parse(data)
    n, m = len(rows), len(cols)
    nonogram = [[' '] * m for _ in range(n)]
    while not solved(nonogram, n, m):
        for i in range(n):
            for j in range(m):
                try_color(i, j, nonogram, rows, cols)
    return nonogram


with open('zad_input.txt') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')
nonogram = solve(data)
result = draw(nonogram, len(nonogram), len(nonogram[0]))
out.write(result)
out.close()
