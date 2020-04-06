def opt_dist(l, d):
    ls = [1] * d + [0] * (len(l)-d)
    min_swaps = len(l)
    for _ in range(len(l) - d + 1):
        cnt = 0
        for j in range(len(l)):
            if l[j] != ls[j]:
                cnt += 1
        if cnt < min_swaps:
            min_swaps = cnt
        # move ->
        ls = [0] + ls[:-1]
    return min_swaps


with open('zad4_input.txt', 'r') as f:
    data = f.read().split('\n')

out = open("zad4_output.txt", 'w')

for line in data:
    line = line.split()
    print(line)
    l = line[0]
    d = int(line[1])
    ls = []
    for el in l:
        ls.append(int(el))
    out.write(str(opt_dist(ls, d)))
    out.write('\n')
out.close()
