def competitiveEating(t, width, precision):
    return str("{number:.{precision}f}".format(number = t,precision = precision)).center(width)
