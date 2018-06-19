def primesSum(a, b):
    return sum([i for i in range(a, b + 1) if not(i < 2 or any(i % x == 0 for x in range(2, int(i ** 0.5 )+1)))])
