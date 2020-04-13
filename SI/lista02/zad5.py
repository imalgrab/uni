import heapq

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
mv = {0: 'U', 1: 'D', 2: 'R', 3: 'L'}

walls = set()
goals = set()


class state:
    def __init__(self, positions, moves):
        self.positions = positions
        self.moves = moves


def len_from_goals(s):
    sum_dist = 0
    for p in s.positions:
        min_dist = 1e9
        for g in goals:
            new_dist = abs(g[0] - p[0]) + abs(g[1] - p[1])
            if new_dist < min_dist:
                min_dist = new_dist
        sum_dist += min_dist
    return sum_dist


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
    q = []
    heapq.heappush(q, (len_from_goals(s), s))
    visited.add(tuple(s.positions))
    while len(q) > 0:
        curr = heapq.heappop(q)[1]
        if is_final(curr):
            return curr.moves
        adjs = get_adj(curr)
        for adj in adjs:
            if tuple(adj.positions) not in visited:
                visited.add(tuple(adj.positions))
                heapq.heappush(q, (len_from_goals(adj), adj))


def start(data):
    goals.clear()
    walls.clear()
    init_state = init(data)
    final_state = bfs(init_state)
    out.write(final_state)
    out.write('\n')


with open('zad_input.txt', 'r') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')

start(data)
out.close()
