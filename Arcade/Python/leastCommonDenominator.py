from fractions import gcd

def leastCommonDenominator(denominators):
    return reduce(lambda a, b: (a * b)//gcd(a, b), denominators)
