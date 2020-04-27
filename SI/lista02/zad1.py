import random
ITERATIONS = 500


def is_completed(rows, row_specs):
    for i in range(len(rows)):
        if sum(rows[i]) != row_specs[i][1]:
            return False
    return True


def opt_dist(l, d):
    s = [0]
    for i in range(len(l)):
        s.append(s[i] + l[i])
    print(s)
    res = len(l)
    for i in range(len(l) - d + 1):
        left = i
        right = i + d - 1
        before = s[left]  # suma jedynek w (0, l-1)
        curr = s[right+1] - s[left]  # suma jedynek w (l, r)
        after = s[len(l)] - s[right+1]  # suma jedynek w (r+1, n-1)
        res = min(res, before + after + d - curr)
        print(l[0:left], l[left:right+1], l[right+1:len(l)])
        print(before + after + d - curr)
    return res


def color_pos(i, j, rows, cols):
    if rows[i][j] == 0:
        rows[i][j] = 1
        cols[j][i] = 1
    else:
        rows[i][j] = 0
        cols[j][i] = 0


def try_color(i, n, m, rows, cols):
    if i % 63:
        color_pos(random.randint(0, n-1), random.randint(0, m-1), rows, cols)
    else:
        coinflip = random.randint(0, 1)  # row / column
        if coinflip:
            r = random.randint(0, n-1)
            for i in range(m):
                pass


def parse(data):
    size = data[0].split()
    n = int(size[0])
    rows = []
    cols = []
    for i in range(1, n+1):
        d = data[i].split()
        row = list(map(int, d))
        s_row = sum(row)
        rows.append((row, s_row))
    for j in range(n+1, len(data)):
        d = data[j].split()
        col = list(map(int, d))
        s_col = sum(col)
        cols.append((col, s_col))
    return (rows, cols)


def solve(data):
    rows, cols = parse(data)
    SPECIFICATION = (rows, cols)
    n = len(rows)
    m = len(cols)
    r = [[0 for _ in range(m)] for _ in range(n)]
    c = [[0 for _ in range(n)] for _ in range(m)]
    i = 0
    while i < ITERATIONS:
        if i == ITERATIONS - 1:
            rows, cols = SPECIFICATION
            r = [[0 for _ in range(m)] for _ in range(n)]
            c = [[0 for _ in range(n)] for _ in range(m)]
        i += 1


with open('zad_input.txt') as f:
    data = f.read().strip().split('\n')

rows, cols = parse(data)
r = [
    [1, 1, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [0, 1, 1, 1, 0],
    [1, 1, 0, 1, 1],
    [1, 1, 1, 1, 1],
]
print(is_completed(r, rows))
