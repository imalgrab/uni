import heapq
import queue

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
mv = {0: 'U', 1: 'D', 2: 'R', 3: 'L'}
walls = set()
goals = set()
dist = {}


class state:
    def __init__(self, positions, moves):
        self.positions = positions
        self.moves = moves

    def __lt__(self, other):
        return len(self.moves) < len(other.moves)


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


def is_final(s):
    for position in s.positions:
        if position not in goals:
            return False
    return True


def find_dist(p):
    q = queue.Queue()
    visited = set()
    q.put((p, 0))
    visited.add(p)
    while not q.empty():
        currp, currd = q.get()
        if currp in goals:
            return currd
        for i in range(4):
            newp = (currp[0] + dx[i], currp[1] + dy[i])
            if newp not in walls and newp not in visited:
                newd = currd + 1
                visited.add(newp)
                q.put((newp, newd))


def gen_dists(n, m):
    for i in range(n):
        for j in range(m):
            if (i, j) not in walls:
                dist[(i, j)] = find_dist((i, j))
    return dist


def heur(s):
    ds = [dist[p] for p in s.positions]
    return max(ds) + len(s.moves)


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
    heapq.heappush(q, (heur(s), s))
    visited.add(tuple(s.positions))
    while len(q) > 0:
        _, curr = heapq.heappop(q)
        if is_final(curr):
            return curr.moves
        adjs = get_adj(curr)
        for adj in adjs:
            if tuple(adj.positions) not in visited:
                visited.add(tuple(adj.positions))
                heapq.heappush(q, (heur(adj), adj))


def start(data):
    goals.clear()
    walls.clear()
    dist.clear()
    init_state = init(data)
    gen_dists(len(data), len(data[0]))
    final_state = bfs(init_state)
    out.write(final_state)
    out.write('\n')


with open('zad_input.txt', 'r') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')

start(data)
out.close()
