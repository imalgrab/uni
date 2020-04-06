import queue

"""
' ' empty
S start
B S-G
# wall
G goal
"""


dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
mv = {0: 'U', 1: 'D', 2: 'R', 3: 'L'}
# (player_pos[], goals[], (p_pos), moves)
VISITED = set()


def start(board):
    VISITED.clear()


with open('zad_input.txt', 'r') as f:
    data = f.read().strip().split('\n')

out = open('zad_output.txt', 'w')
start(data)

out.close()
