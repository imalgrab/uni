import queue
import time


class State:
    def __init__(self, color, pos_wk, pos_wr, pos_bk, n):
        self.color = color
        self.pos_wk = pos_wk
        self.pos_wr = pos_wr
        self.pos_bk = pos_bk
        self.n = n


states = set()
prev = {}
xs = [0, 1, 1, 1, 0, -1, -1, -1]
ys = [1, 1, 0, -1, -1, -1, 0, 1]


def convertPosition(p):
    return (ord(p[0]) - 96, int(p[1]))


def isValidPosition(who, pos, wk, wr, bk):
    if who == 'black_king':
        if (wk, wr, pos) in states:
            return False
        states.add((wk, wr, pos))
        # rook's row or column or white king
        if pos[0] == wr[0] or pos[1] == wr[1] or pos == wk:
            return False
        # reachable from white king
        for i in range(8):
            wk_x = wk[0] + xs[i]
            wk_y = wk[1] + ys[i]
            if (wk_x, wk_y) == pos:
                return False
        # if x€[1,8] and y€[1,8] it's fine
        return (1, 1) <= pos <= (8, 8)
    if who == 'white_king':
        if (pos, wr, bk) in states:
            return False
        states.add((pos, wr, bk))
        # cannot step on rook or black king
        if pos == wr or pos == bk:
            return False
        # reachable from black king
        for i in range(8):
            bk_x = bk[0] + xs[i]
            bk_y = bk[1] + ys[i]
            if (bk_x, bk_y) == pos:
                return False
        # if x€[1,8] and y€[1,8] it's fine
        return (1, 1) <= pos <= (8, 8)
    if who == 'white_rook':
        if (wk, pos, bk) in states:
            return False
        states.add((wk, pos, bk))
        # on wk
        if pos == wk or pos == bk:
            return False
        # out of bounds
        if (pos[0] < 1 or pos[0] > 8) or (pos[1] < 1 or pos[1] > 8):
            return False
        # prev wr under wk and new wr tried to stand on it or above
        if wr[0] == wk[0] and wr[1] < wk[1] and pos[1] >= wk[1]:
            return False
        # prev wr above
        if wr[0] == wk[0] and wr[1] > wk[1] and pos[1] <= wk[1]:
            return False
        # prev wr on the left
        if wr[1] == wk[1] and wr[0] < wk[0] and pos[0] >= wk[0]:
            return False
        # prev wr on the right
        if wr[1] == wk[1] and wr[0] > wk[0] and pos[0] <= wk[0]:
            return False
        # reachable from black king
        for i in range(8):
            bk_x = bk[0] + xs[i]
            bk_y = bk[1] + ys[i]
            if (bk_x, bk_y) == pos:
                return False
        return True


def checkmated(curr):
    wk, wr, bk = curr.pos_wk, curr.pos_wr, curr.pos_bk
    if bk == (1, 1) and wk == (2, 3) and wr[1] == 1:
        return True
    if bk == (1, 1) and wk == (3, 2) and wr[0] == 1:
        return True
    if bk == (1, 8) and wk == (2, 6) and wr[1] == 8:
        return True
    if bk == (1, 8) and wk == (3, 7) and wr[0] == 1:
        return True
    if bk == (8, 8) and wk == (6, 7) and wr[0] == 8:
        return True
    if bk == (8, 8) and wk == (7, 6) and wr[1] == 8:
        return True
    if bk == (8, 1) and wk == (6, 2) and wr[0] == 8:
        return True
    if bk == (8, 1) and wk == (7, 3) and wr[1] == 1:
        return True
    if bk[1] == 1 and wk[1] == 3 and bk[0] == wk[0] and wr[1] == 1:
        return True
    if bk[1] == 8 and wk[1] == 6 and bk[0] == wk[0] and wr[1] == 8:
        return True
    if bk[0] == 1 and wk[0] == 3 and bk[1] == wk[1] and wr[0] == 1:
        return True
    if bk[0] == 8 and wk[0] == 6 and bk[1] == wk[1] and wr[0] == 8:
        return True
    return False


def findMinMoves(color, wk, wr, bk, debug):
    q = queue.Queue()
    states.clear()
    s = State(color, wk, wr, bk, 0)
    prev[s] = 0
    q.put(s)
    while not q.empty():
        curr = q.get()
        if checkmated(curr):
            if debug:
                ls = [(curr.color, curr.pos_wk, curr.pos_wr, curr.pos_bk)]
                s = prev[curr]
                while s != 0:
                    ls.append((s.color, s.pos_wk, s.pos_wr, s.pos_bk))
                    s = prev[s]
                for l in ls[::-1]:
                    print(l)
            return curr.n
        if curr.color == 'black':
            for i in range(8):
                new_x = curr.pos_bk[0] + xs[i]
                new_y = curr.pos_bk[1] + ys[i]
                if isValidPosition('black_king', (new_x, new_y), curr.pos_wk, curr.pos_wr, curr.pos_bk):
                    s = State('white', curr.pos_wk, curr.pos_wr,
                              (new_x, new_y), curr.n+1)
                    prev[s] = curr
                    q.put(s)
        elif curr.color == 'white':
            for i in range(8):
                new_x = curr.pos_wk[0] + xs[i]
                new_y = curr.pos_wk[1] + ys[i]
                if isValidPosition('white_king', (new_x, new_y), curr.pos_wk, curr.pos_wr, curr.pos_bk):
                    s = State('black', (new_x, new_y),
                              curr.pos_wr, curr.pos_bk, curr.n+1)
                    prev[s] = curr
                    q.put(s)
            for i in range(7):
                new_x = curr.pos_wr[0] + i + 1
                new_y = curr.pos_wr[1]
                if isValidPosition('white_rook', (new_x, new_y), curr.pos_wk, curr.pos_wr, curr.pos_bk):
                    s = State('black', curr.pos_wk,
                              (new_x, new_y), curr.pos_bk, curr.n+1)
                    prev[s] = curr
                    q.put(s)
            for i in range(7):
                new_x = curr.pos_wr[0] - (i + 1)
                new_y = curr.pos_wr[1]
                if isValidPosition('white_rook', (new_x, new_y), curr.pos_wk, curr.pos_wr, curr.pos_bk):
                    s = State('black', curr.pos_wk,
                              (new_x, new_y), curr.pos_bk, curr.n+1)
                    prev[s] = curr
                    q.put(s)
            for i in range(7):
                new_x = curr.pos_wr[0]
                new_y = curr.pos_wr[1] + i + 1
                if isValidPosition('white_rook', (new_x, new_y), curr.pos_wk, curr.pos_wr, curr.pos_bk):
                    s = State('black', curr.pos_wk,
                              (new_x, new_y), curr.pos_bk, curr.n+1)
                    prev[s] = curr
                    q.put(s)
            for i in range(7):
                new_x = curr.pos_wr[0]
                new_y = curr.pos_wr[1] - (i + 1)
                if isValidPosition('white_rook', (new_x, new_y), curr.pos_wk, curr.pos_wr, curr.pos_bk):
                    s = State('black', curr.pos_wk,
                              (new_x, new_y), curr.pos_bk, curr.n+1)
                    prev[s] = curr
                    q.put(s)


def solve(debug, data, out):
    data = data[0].split()
    color = data[0]
    wk = convertPosition(data[1])
    wr = convertPosition(data[2])
    bk = convertPosition(data[3])
    if debug:
        print(findMinMoves(color, wk, wr, bk, debug))
    else:
        res = str(findMinMoves(color, wk, wr, bk, debug))
        out.write(res)
        out.write('\n')


with open('zad1_input.txt', 'r') as f:
    data = f.read().split('\n')

out = open("zad1_output.txt", 'w')

debug = False

solve(debug, data, out)

out.close()

# expected
# 6
# 9
# 9
# 6
# 9
# 10
