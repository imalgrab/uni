def opt_dist(l, d):
    s = [0]
    for i in range(len(l)):
        s.append(s[i] + l[i])
    for i in range(len(l) - d):
        left = i
        right = i + d - 1
        curr = s[right+1] - s[left]
        print(curr)


l = [0, 0, 1, 0, 0, 0, 1, 0, 0, 0]
opt_dist(l, 5)
