import heapq

"""
. empty
W wall
K player
B box
G goal
* box on G
+ player on G
"""


# (player_position, boxes_positions)
VISITED = set()
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
mv = {0: 'U', 1: 'D', 2: 'R', 3: 'L'}


def heur(state, goals):
    p_pos = state[0]
    boxes = state[1]
    m_len = len(state[2])
    min_value = 1e9
    for box in boxes:
        for goal in goals:
            act_dist = abs(box[0] - goal[0]) + abs(box[1] - goal[1])
            act_dist += abs(p_pos[0] - box[0]) + abs(p_pos[1] - box[1])
            min_value = min(act_dist, min_value)
    return min_value + m_len


def is_finish(state, goals):
    boxes = state[1]
    for box in boxes:
        if box not in goals:
            return False
    return True


def init(board):
    boxes = []
    goals = []
    walls = []
    p_pos = (0, 0)
    n, m = len(board), len(board[0])
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'K':
                p_pos = (i, j)
            elif board[i][j] == 'B':
                boxes.append((i, j))
            elif board[i][j] == 'G':
                goals.append((i, j))
            elif board[i][j] == '*':
                goals.append((i, j))
                boxes.append((i, j))
            elif board[i][j] == '+':
                p_pos = (i, j)
                goals.append((i, j))
            elif board[i][j] == 'W':
                walls.append((i, j))
    return (p_pos, boxes, []), goals, walls


def get_adj(state, goals, walls):
    adj = []
    for i in range(4):
        curr_pos = state[0]
        boxes = state[1][:]
        moves = state[2][:]
        player_moved = False
        new_pos = (curr_pos[0] + dx[i], curr_pos[1] + dy[i])
        if new_pos not in walls:
            if new_pos in boxes:
                new_box_pos = (new_pos[0] + dx[i], new_pos[1] + dy[i])
                if new_box_pos not in walls and new_box_pos not in boxes:
                    boxes.remove(new_pos)
                    boxes.append(new_box_pos)
                    curr_pos = new_pos
                    player_moved = True
            elif new_pos not in boxes:
                curr_pos = new_pos
                player_moved = True
            if player_moved:
                moves.append(mv[i])
            adj_state = (curr_pos, boxes, moves)
            adj.append(adj_state)
    return adj


def start(board):
    VISITED.clear()
    # s - p_pos, boxes, moves
    s, goals, walls = init(board)
    q = []
    heapq.heappush(q, (heur(s, goals), s))
    VISITED.add((s[0], tuple(s[1])))
    while len(q) > 0:
        curr = heapq.heappop(q)[1]
        adj = get_adj(curr, goals, walls)
        for a in adj:
            if (a[0], tuple(a[1])) not in VISITED:
                VISITED.add((a[0], tuple(a[1])))
                heapq.heappush(q, (heur(a, goals), a))
                if is_finish(a, goals):
                    out.write(''.join(a[2]))
                    out.write('\n')
                    return


with open('zad_input.txt', 'r') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')
start(data)

out.close()
