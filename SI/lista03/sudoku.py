import sys


def V(i, j):
    return 'V%d_%d' % (i, j)


def domains(Vs):
    return [q + ' in 1..9' for q in Vs]


def all_different(Qs):
    return 'all_distinct([' + ', '.join(Qs) + '])'


def get_column(j):
    return [V(i, j) for i in range(9)]


def get_row(i):
    return [V(i, j) for j in range(9)]


def get_sq(i):
    sqs = {0: (0, 0), 1: (0, 3), 2: (0, 6), 3: (3, 0), 4: (3, 3),
           5: (3, 6), 6: (6, 0), 7: (6, 3), 8: (6, 6)}
    x, y = sqs[i]
    return[V(i, j) for i in range(x, x+3) for j in range(y, y+3)]


def horizontal():
    return [all_different(get_row(i)) for i in range(9)]


def vertical():
    return [all_different(get_column(j)) for j in range(9)]


def inner_squares():
    return [all_different(get_sq(i)) for i in range(9)]


def print_constraints(Cs, indent, d):
    position = indent
    print((indent - 1) * ' ', end=' ')
    for c in Cs:
        print(c + ',', end=' ')
        position += len(c)
        if position > d:
            position = indent
            print()
            print((indent - 1) * ' ', end=' ')


def sudoku(assigments):
    variables = [V(i, j) for i in range(9) for j in range(9)]

    print(':- use_module(library(clpfd)).')
    print('solve([' + ', '.join(variables) + ']) :- ')

    cs = domains(variables) + vertical() + horizontal() + inner_squares()
    for i, j, val in assigments:
        cs.append('%s #= %d' % (V(i, j), val))

    print_constraints(cs, 4, 70),
    print()
    print('    labeling([ff], [' + ', '.join(variables) + ']).')
    print()
    print(':- solve(X), write(X), nl.')


if __name__ == "__main__":
    row = 0
    triples = []

    for x in sys.stdin:
        x = x.strip()
        if len(x) == 9:
            for i in range(9):
                if x[i] != '.':
                    triples.append((row, i, int(x[i])))
            row += 1
    sudoku(triples)
