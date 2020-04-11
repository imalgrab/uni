import queue
import random

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
mv = {0: 'U', 1: 'D', 2: 'R', 3: 'L'}

board = []
goals = set()


class state:
    def __init__(self, positions, moves):
        self.positions = positions
        self.moves = moves


def is_final(s):
    for position in s.positions:
        if position not in goals:
            return False
    return True


def move(s, d):
    ps = set()
    ms = ""
    for pos in s.positions:
        new_pos = pos[0] + dx[d], pos[1] + dy[d]
        if board[new_pos[0]][new_pos[1]] != '#':
            ps.add(new_pos)
        else:
            ps.add(pos)
        ms += mv[d]
    return state(ps, s.moves + ms)


def rand_moves(s, n):
    for _ in range(n):
        d = random.randint(0, 3)
        s = move(s, d)

    return state


def init(b):
    positions = []
    n = len(b)
    m = len(b[0])
    for i in range(n):
        board.append(b[i])
        for j in range(m):
            if b[i][j] == 'S':
                positions.append((i, j))
            elif b[i][j] == 'G':
                goals.add((i, j))
            elif b[i][j] == 'B':
                positions.append((i, j))
                goals.add((i, j))
    return state(positions, "")


def get_adj(s):
    adj = []
    for i in range(4):
        adj_state = move(s, i)
        adj.append(adj_state)
    return adj


def bfs(s):
    q = queue.Queue()
    visited = set()
    q.put(s)
    visited.add(s)

    while not q.empty():
        curr = q.get()
        if len(curr.moves) > 150:
            return "UPS!!! " + curr.moves
        if is_final(curr):
            return curr.moves
        adj = get_adj(curr)
        for adj_state in adj:
            if adj_state not in visited:
                visited.add(adj_state)
                q.put(adj_state)


def start(data):
    goals.clear()
    board.clear()
    init_state = init(data)
    mid_state = rand_moves(init_state, 30)
    final_state = bfs(mid_state)
    print(final_state)
    # out.write(final_state)
    # out.write('\n')


with open('zad_input.txt', 'r') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')

start(data)
out.close()
