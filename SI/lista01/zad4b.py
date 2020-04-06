def opt_dist(l, d):
    s = [0]
    for i in range(len(l)):
        s.append(s[i] + l[i])
    print(s)
    res = len(l)
    for i in range(len(l) - d + 1):
        left = i
        right = i + d - 1
        before = s[left]  # suma jedynek w (0, l-1)
        curr = s[right+1] - s[left]  # suma jedynek w (l, r)
        after = s[len(l)] - s[right+1]  # suma jedynek w (r+1, n-1)
        res = min(res, before + after + d - curr)
        print(l[0:left], l[left:right+1], l[right+1:len(l)])
        print(before + after + d - curr)
    return res


print(opt_dist([0, 0, 1, 0, 0, 0, 1, 0, 0, 0], 5))  # powinna zwróci¢ 3
# print(opt_dist([0, 0, 1, 0, 0, 0, 1, 0, 0, 0], 4))  # powinna zwróci¢ 4
# print(opt_dist([0, 0, 1, 0, 0, 0, 1, 0, 0, 0], 3))  # powinna zwróci¢ 3
# print(opt_dist([0, 0, 1, 0, 0, 0, 1, 0, 0, 0], 2))  # powinna zwróci¢ 2
# print(opt_dist([0, 0, 1, 0, 0, 0, 1, 0, 0, 0], 1))  # powinna zwróci¢ 1
# print(opt_dist([0, 0, 1, 0, 0, 0, 1, 0, 0, 0], 0))  # powinna zwróci¢ 2
