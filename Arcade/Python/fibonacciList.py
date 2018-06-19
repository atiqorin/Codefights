def fibonacciList(n):
    return [[0] * x for x in reduce(lambda x, _: x + [sum(x[-2:])], range(n - 2), [0,1])]
