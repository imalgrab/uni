with open('words_for_ai1.txt', 'r', encoding='utf-8') as f:
    S = set(f.read().split('\n'))
with open('zad2_input.txt', 'r', encoding='utf-8') as f:
    t = f.read()


def editLine(words):
    w = ['']
    for l in words:
        w.append(l)
    ans = [False for _ in range(len(w))]
    ans[0] = True
    # d[i] start słowa kończącego się w i
    d = [[] for _ in range(len(w))]
    for i in range(1, len(w)):
        for j in range(1, i+1):
            if ans[j-1] and ''.join(w[j:i+1]) in S:
                ans[i] = True
                d[i].append(j)
    # [początki, numer, litera]
    data = [[d[x], x, w[x]] for x in range(len(w))]
    # dp = [suma, pozycja, litera]
    dp = [[0, -1, w[x]] for x in range(len(w))]
    for curr in range(1, len(w)):
        # indeksy w których zaczynają się słowa kończące się na curr
        s = data[curr][0]
        curr_sum = 0
        best_s = 0
        for start in s:
            curr_len = (data[curr][1] - start + 1) ** 2
            prev_sum = dp[start-1][0]
            if curr_len + prev_sum > curr_sum:
                curr_sum = prev_sum + curr_len
                best_s = data[start][1]
        dp[curr][0] = curr_sum
        dp[curr][1] = best_s
    return makeSentence(dp, w)


def makeSentence(dp, w):
    res = []
    ret = ''
    end = len(w)-1
    while end > 0:
        beg = dp[end][1]
        res.append(w[beg:end+1])
        end = beg-1
    for w in reversed(res):
        w = ''.join(w)
        ret += w + ' '
    return ret


t = t.split('\n')

out = open('zad2_output.txt', 'w', encoding='utf-8')

for line in t:
    ll = editLine(line)
    out.write(ll)
    out.write('\n')
out.close()
