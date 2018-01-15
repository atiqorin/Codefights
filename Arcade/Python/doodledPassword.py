from collections import deque

def doodledPassword(digits):
    n = len(digits)
    res = [deque(digits) for _ in range(n)]
    deque(map(lambda a, b: a.rotate(b), res, reversed(range(1, n + 1))), 0)
    return [list(d) for d in res]
