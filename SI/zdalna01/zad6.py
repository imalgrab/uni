import random
import time


def queens(n):
    solved = False
    cnt = 0
    while not solved:
        cnt += 1
        board = [['0' for _ in range(n)] for _ in range(n)]
        for i in range(n):
            av = [row for row in range(n) if board[row][i] == '0']
            if av == []:
                break
            else:
                r = random.choice(av)
                board[r][i] = '1'
                if i == n - 1:
                    solved = True
                    break
                u = r+1
                l = r-1
                for j in range(i+1, n):
                    board[r][j] = '#'
                    if u < n:
                        board[u][j] = '#'
                        u += 1
                    if l >= 0:
                        board[l][j] = '#'
                        l -= 1
    return (board, cnt)

# (a)

# N = 20000
# num = 0
# for i in range(N):
#     cnt = queens(board)
#     if cnt == 1:
#         num += 1
# print(f'{num / N * 100}%')

# (b)

start = time.time()
end = time.time() - start
i = 40
while end <= 5:
    i += 1
    start = time.time()
    d = queens(i)
    end = time.time() - start
    # print('n:', i)
    # print('time:', end)
    # print('restarts:', d[1])
print('result:', i)
