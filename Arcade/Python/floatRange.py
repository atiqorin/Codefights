from itertools import count, takewhile

def floatRange(start, stop, step):
    gen = takewhile(lambda s: s < stop, count(start, step))
    return list(gen)
