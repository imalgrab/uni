import random
import sys
from collections import defaultdict as dd
from copy import deepcopy

BOK = 50
SX = -100
SY = 0
M = 8
DEPTH = 1

pos_weights = ((200, -100, 100, 50, 50, 100, -100, 200),
               (-100, -200, -50, -50, -50, -50, -200, -100),
               (100, -50, 100, 0, 0, 100, -50, 100),
               (50, -50, 0, 0, 0, 0, -50, 50),
               (50, -50, 0, 0, 0, 0, -50, 50),
               (100, -50, 100, 0, 0, 100, -50, 100),
               (-100, -200, -50, -50, -50, -50, -200, -100),
               (200, -100, 100, 50, 50, 100, -100, 200))

# pos_weights = [[534, 668, 700, 692, 706, 730, 614, 580],
#                [610, 582, 256, 180, 218, 222, 548, 586],
#                [674, 272, 358, 194, 174, 344, 266, 670],
#                [724, 252, 154, 244, 308, 120, 290, 756],
#                [722, 268, 176, 346, 242, 202, 268, 754],
#                [682, 310, 368, 164, 180, 272, 290, 720],
#                [624, 514, 350, 280, 286, 346, 494, 668],
#                [562, 638, 720, 746, 704, 674, 630, 492]]


def initial_board():
    B = [[None] * M for i in range(M)]
    B[3][3] = 1
    B[4][4] = 1
    B[3][4] = 0
    B[4][3] = 0
    return B


class Board:
    dirs = [(0, 1), (1, 0), (-1, 0), (0, -1),
            (1, 1), (-1, -1), (1, -1), (-1, 1)]

    def __init__(self):
        self.board = initial_board()
        self.fields = set()
        self.move_list = []
        self.history = []
        for i in range(M):
            for j in range(M):
                if self.board[i][j] == None:
                    self.fields.add((j, i))

    def draw(self):
        for i in range(M):
            res = []
            for j in range(M):
                b = self.board[i][j]
                if b == None:
                    res.append('.')
                elif b == 1:
                    res.append('#')
                else:
                    res.append('o')
            print(''.join(res))
        print()

    def moves(self, player):
        res = []
        for (x, y) in self.fields:
            if any(self.can_beat(x, y, direction, player) for direction in Board.dirs):
                res.append((x, y))
        if not res:
            return [None]
        return res

    def can_beat(self, x, y, d, player):
        dx, dy = d
        x += dx
        y += dy
        cnt = 0
        while self.get(x, y) == 1-player:
            x += dx
            y += dy
            cnt += 1
        return cnt > 0 and self.get(x, y) == player

    def get(self, x, y):
        if 0 <= x < M and 0 <= y < M:
            return self.board[y][x]
        return None

    def do_move(self, move, player):
        self.history.append([x[:] for x in self.board])
        self.move_list.append(move)

        if move == None:
            return
        x, y = move
        x0, y0 = move
        self.board[y][x] = player
        self.fields -= set([move])
        for dx, dy in self.dirs:
            x, y = x0, y0
            to_beat = []
            x += dx
            y += dy
            while self.get(x, y) == 1-player:
                to_beat.append((x, y))
                x += dx
                y += dy
            if self.get(x, y) == player:
                for (nx, ny) in to_beat:
                    self.board[ny][nx] = player

    def result(self):
        res = 0
        for y in range(M):
            for x in range(M):
                b = self.board[y][x]
                if b == 0:
                    res -= 1
                elif b == 1:
                    res += 1
        return res

    def terminal(self):
        if not self.fields:
            return True
        if len(self.move_list) < 2:
            return False
        return self.move_list[-1] == self.move_list[-2] == None

    def random_move(self, player):
        ms = self.moves(player)
        if ms:
            return random.choice(ms)
        return [None]

    def heuristic(self):
        value = 0
        for x in range(M):
            for y in range(M):
                if self.board[y][x] == 1:
                    value += pos_weights[y][x]
                elif self.board[y][x] == 0:
                    value -= pos_weights[y][x]
        return value

    def best_move(self, player):
        def max_value(state, alpha, beta, depth, player):
            if state.terminal() or depth == DEPTH or state.moves(player) == [None]:
                return state.heuristic()
            value = -10e9
            for action in state.moves(player):
                state1 = deepcopy(state)
                state1.do_move(action, player)
                value = max(value, min_value(
                    state1, alpha, beta, depth+1, 1-player))
                if value >= beta:
                    return value
                alpha = max(alpha, value)
            return value

        def min_value(state, alpha, beta, depth, player):
            if state.terminal() or depth == DEPTH or state.moves(player) == [None]:
                return state.heuristic()
            value = 1e9
            for action in state.moves(player):
                state1 = deepcopy(state)
                state1.do_move(action, player)
                value = min(value, max_value(
                    state1, alpha, beta, depth+1, 1-player))
                if value <= alpha:
                    return value
                beta = min(beta, value)
            return value
        best_xy = None
        best_val = -1e9
        for action in self.moves(player):
            state1 = deepcopy(self)
            state1.do_move(action, player)
            value = max_value(state1, -1e9, 1e9, 1, 1-player)
            if value > best_val:
                best_xy = action
                best_val = value
        return best_xy


# white - 0 'o'
# black - 1 '#'
def_cnt = 0
for _ in range(1000):
    player = _ % 2
    B = Board()
    while True:
        if player == 1:
            m = B.best_move(player)
            B.do_move(m, player)
        else:
            m = B.random_move(player)
            B.do_move(m, player)
        player = 1-player
        if B.terminal():
            break
    res = B.result()
    if res < 0:
        def_cnt += 1
print(f'{def_cnt} defeats after {_+1} games')
sys.exit(0)
