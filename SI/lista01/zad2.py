with open('lista01/words_for_ai1.txt') as f:
    S = set(word.strip() for word in f)
with open('lista01/pan_tadeusz_bez_spacji.txt') as f:
    t = f.read()


t = 'kołowylotdrogą'
a = [False for _ in range(len(t))]
for i in range(1, len(t)):
    # t[0:i+1] <- słowo od początku t do i, np. t='kotek', t[0:3] => kot
    if t[0:i+1] in S:
        a[i] = True

for i in range(len(t)):
    print(t[0:i+1], a[i])