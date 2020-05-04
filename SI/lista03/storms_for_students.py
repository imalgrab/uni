def B(i, j):
    return 'B_%d_%d' % (i, j)


def domains(variables):
    return [v + ' in 0..1' for v in variables]


def sum_row(m):
    for i, val in enumerate(raws):
        row = [B(i, j) for j in range(m)]
        writeln('sum([' + ', '.join(row) + '], #=, ' + str(val) + '),')


def sum_col(n):
    for j, val in enumerate(cols):
        col = [B(i, j) for i in range(n)]
        writeln('sum([' + ', '.join(col) + '], #=, ' + str(val) + '),')


def threes_in_rows(n, m):
    for i in range(n):
        ts = [B(i, j) for j in range(m)]  # wszystkie wsp. w i-tym wierszu
        for x in range(m-3+1):
            output.write(ts[x+1] + ' #= 1 #==> ' +
                         ts[x] + ' + ' + ts[x+2] + ' #> 0, ')


def threes_in_cols(n, m):
    for j in range(m):
        ts = [B(i, j) for i in range(n)]  # wszystkie wsp. w j-tej kolumnie
        for x in range(n-3+1):
            output.write(ts[x+1] + ' #= 1 #==> ' + ts[x] +
                         ' + ' + ts[x+2] + ' #> 0, ')


def squares_of_4s(n, m):
    for i in range(n-1):
        for j in range(m-1):
            output.write(B(i, j) + ' + ' + B(i+1, j+1) +
                         ' #= 2 #<==> ' + B(i, j+1) + ' + ' + B(i+1, j) + ' #= 2, ')


def storms(raws, cols, triples):
    writeln(':- use_module(library(clpfd)).')

    R = len(raws)
    C = len(cols)

    bs = [B(i, j) for i in range(R) for j in range(C)]

    writeln('solve([' + ', '.join(bs) + ']) :- ')

    for d in domains(bs):
        dm = d + ', '
        output.write(dm)
    writeln('')
    sum_row(C)
    sum_col(R)
    threes_in_rows(R, C)
    writeln('')
    threes_in_cols(R, C)
    writeln('')
    squares_of_4s(R, C)
    writeln('')

    for i, j, val in triples:
        output.write('%s #= %d, ' % (B(i, j), val))
    writeln('')
    writeln('    labeling([ff], [' + ', '.join(bs) + ']).')
    writeln('')
    writeln(":- tell('prolog_result.txt'), solve(X), write(X), nl, told.")


def writeln(s):
    output.write(s + '\n')


txt = open('zad_input.txt').readlines()
output = open('zad_output.txt', 'w')

raws = list(map(int, txt[0].split()))
cols = list(map(int, txt[1].split()))
triples = []

for i in range(2, len(txt)):
    if txt[i].strip():
        triples.append((map(int, txt[i].split())))

storms(raws, cols, triples)
