import queue

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
mv = {0: 'U', 1: 'D', 2: 'R', 3: 'L'}

walls = set()
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
        x = pos[0] + dx[d]
        y = pos[1] + dy[d]
        if (x, y) not in walls:
            ps.add((x, y))
        else:
            ps.add(pos)
    ms += mv[d]
    return state(ps, s.moves+ms)


def moves(s, n, d):
    for _ in range(n):
        s = move(s, d)
    return s


def init(b):
    positions = set()
    n = len(b)
    m = len(b[0])
    for i in range(n):
        for j in range(m):
            if b[i][j] == 'S':
                positions.add((i, j))
            elif b[i][j] == 'G':
                goals.add((i, j))
            elif b[i][j] == 'B':
                positions.add((i, j))
                goals.add((i, j))
            elif b[i][j] == '#':
                walls.add((i, j))
    return state(positions, "")


def get_adj(s):
    adj = []
    for i in range(4):
        ps = set()
        ms = ""
        for p in s.positions:
            x = p[0] + dx[i]
            y = p[1] + dy[i]
            if (x, y) not in walls:
                ps.add((x, y))
            else:
                ps.add(p)
        ms += mv[i]
        adj_state = state(ps, s.moves + ms)
        adj.append(adj_state)
    return adj


def bfs(s):
    visited = set()
    cntr = 0
    shortest = len(s.positions)
    q = queue.Queue()
    q.put(s)
    visited.add(tuple(s.positions))
    while not q.empty():
        print(cntr)
        curr = q.get()
        if is_final(curr):
            return curr.moves
        adjs = get_adj(curr)
        for adj in adjs:
            if tuple(adj.positions) not in visited:
                if len(adj.positions) < shortest:
                    visited.clear()
                    q.queue.clear()
                    shortest = len(adj.positions)
                    visited.add(tuple(adj.positions))
                    q.put(adj)
                    break
                visited.add(tuple(adj.positions))
                q.put(adj)


def start(data):
    goals.clear()
    walls.clear()
    init_state = init(data)
    mid_state = moves(init_state, len(data)-2, 1)
    mid_state = moves(mid_state, len(data[0])-2, 3)
    final_state = bfs(mid_state)
    out.write(final_state)
    out.write('\n')


with open('zad_input.txt', 'r') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')

start(data)
out.close()
