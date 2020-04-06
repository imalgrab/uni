import random

# spades ♠, clubs ♣, hearts ♥, diamonds ♦

numbers = [str(i) for i in range(2, 11)]
figures = ['J', 'Q', 'K', 'A']
suits = ['s', 'c', 'h', 'd']
figurant = [f+s for f in figures for s in suits]
blotkarz = [n+s for n in numbers for s in suits]
fig_val = {'J': 11, 'Q': 12, 'K': 13, 'A': 14}
f = set(figures)

blotkarz1 = [n+'d' for n in numbers]
blotkarz2 = [n+s for n in ['8', '9', '10'] for s in suits]


def is_fig(c):
    return c[:-1] in f


def card_val(c):
    if is_fig(c):
        return fig_val[c[0]]
    return int(c[:-1])


def card_suit(c):
    return c[-1]


def sort_cards(h):
    h.sort(key=card_val)


def is_straight_flush(b):
    for i in range(1, 5):
        if card_val(b[i]) != (card_val(b[i-1]) + 1) or card_suit(b[i]) != card_suit(b[i-1]):
            return False
    return True


def is_four_of_a_kind(h):
    for i in range(2):
        if card_val(h[i]) == card_val(h[i+1]) == card_val(h[i+2]) == card_val(h[i+3]):
            return True
    return False


def is_full_house(h):
    case_1 = card_val(h[0]) == card_val(h[1]) and card_val(
        h[2]) == card_val(h[3]) == card_val(h[4])
    case_2 = card_val(h[0]) == card_val(h[1]) == card_val(h[2]) and card_val(
        h[3]) == card_val(h[4])
    return case_1 or case_2


def is_flush(b):
    for i in range(1, 5):
        if b[i-1][-1] != b[i][-1]:
            return False
    return True


def is_straight(b):
    for i in range(1, 5):
        if card_val(b[i-1]) != (card_val(b[i]) + 1):
            return False
    return True


def is_three_of_a_kind(h):
    for i in range(3):
        if card_val(h[i]) == card_val(h[i+1]) == card_val(h[i+2]):
            return True
    return False


def is_two_pairs(h):
    if card_val(h[0]) == card_val(h[1]) and card_val(h[2]) == card_val(h[3]):
        return True
    if card_val(h[0]) == card_val(h[1]) and card_val(h[3]) == card_val(h[4]):
        return True
    if card_val(h[1]) == card_val(h[2]) and card_val(h[3]) == card_val(h[4]):
        return True
    return False


def is_pair(h):
    for i in range(1, 5):
        if card_val(h[i-1]) == card_val(h[i]):
            return True
    return False


def game(blotkarz, figurant):
    bl = 0
    fg = 0
    n = 10000
    for _ in range(n):
        for _ in range(7):
            random.shuffle(figurant)
            random.shuffle(blotkarz)
        b = blotkarz[:5]
        f = figurant[:5]
        sort_cards(b)
        sort_cards(f)
        if is_straight_flush(b):
            bl += 1
        elif is_four_of_a_kind(f):
            fg += 1
        elif is_four_of_a_kind(b):
            bl += 1
        elif is_full_house(f):
            fg += 1
        elif is_full_house(b):
            bl += 1
        elif is_flush(b):
            bl += 1
        elif is_straight(b):
            bl += 1
        elif is_three_of_a_kind(f):
            fg += 1
        elif is_three_of_a_kind(b):
            bl += 1
        elif is_two_pairs(f):
            fg += 1
        elif is_two_pairs(b):
            bl += 1
        elif is_pair(f):
            fg += 1
        elif is_pair(b):
            bl += 1
        else:
            fg += 1
        # print(b)
        # print(f)
        # print(bl, fg)
    print(n, 'games', 'figurant:', fg, 'blotkarz:', bl)
    print('Chance of winning: ', bl / n * 100, '%', sep='')


game(blotkarz, figurant)  # klasycznie
game(blotkarz1, figurant)  # blotki tylko w jednym kolorze
game(blotkarz2, figurant)  # blotki tyko 8,9,10
