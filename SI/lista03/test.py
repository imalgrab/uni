def B(i, j):
    return 'B_%d_%d' % (i, j)


def suma_wierszy(col_len):
    for i, r in enumerate(raws):
        row = [B(i, j) for j in range(col_len)]
        writeln(f"    sum([{', '.join(row)}], #=, {r}), ")


def suma_kolumn(row_len):
    for j, l in enumerate(cols):
        col = [B(i, j) for i in range(row_len)]
        writeln(f"    sum([{', '.join(col)}], #=, {l}), ")


def wiersz_trojka(row_len, col_len):
    for r in range(row_len):
        write('    ')
        for l in range(col_len - 2):
            write(f'{B(r, l)} + 2 * {B(r, l+1)} + 3 * {B(r, l+2)} #\\= 2, ')
        writeln('')


def kolumna_trojka(row_len, col_len):
    for l in range(col_len):
        write('    ')
        for r in range(row_len - 2):
            write(f'{B(r, l)} + 2 * {B(r+1, l)} + 3 * {B(r+1, l)} #\\= 2, ')
        writeln('')


def kwadracik(row_len, col_len):
    for r in range(row_len - 1):
        write('    ')
        for l in range(col_len - 1):
            # jak przekątna pełna, to cały kwadracik pełny
            write(
                f'{B(r, l)} + {B(r+1, l+1)} #= 2 #<==> {B(r, l+1)} + {B(r+1, l)} #= 2, ')
        writeln('')


def storms(raws, cols, triples):
    writeln(':- use_module(library(clpfd)).')

    R = len(raws)
    C = len(cols)

    bs = [B(i, j) for i in range(R) for j in range(C)]

    writeln('solve([' + ', '.join(bs) + ']) :- ')
    # TODO: add some constraints
    # dziedziny
    write('    ')
    for b in bs:
        write(f'{b} in 0..1, ')
    writeln('')

    # suma wierszy musi sie zgadzac
    suma_wierszy(C)

    # suma kolumn też
    suma_kolumn(R)

    # B(i, j) | B(i, j+1) | B(i, j+2)
    # w takim wierszu jak B(i, j+1) jest 1 to reszta też musi być
    wiersz_trojka(R, C)

    # to samo dla kolumn
    kolumna_trojka(R, C)

    # B(i, j)   | B(i+1,j)      w takim kwadracie nie może być pustych
    # B(i, j+1) | B(i+1, j+1)   rogów (ani na przekątnej, ani pojedynczego)
    kwadracik(R, C)

    # początkowe wartości
    write('    ')
    for x, y, val in triples:
        write('%s #= %d, ' % (B(x, y), val))
    writeln('')

    writeln('    labeling([ff], [' + ', '.join(bs) + ']).')
    writeln('')
    writeln(":- tell('prolog_result.txt'), solve(X), write(X), nl, told.")


def writeln(s):
    output.write(s + '\n')


def write(s):
    output.write(s)


txt = open('zad_input.txt').readlines()
output = open('zad_output.txt', 'w')

raws = list(map(int, txt[0].split()))
cols = list(map(int, txt[1].split()))
triples = []

for i in range(2, len(txt)):
    if txt[i].strip():
        triples.append(map(int, txt[i].split()))

storms(raws, cols, triples)
