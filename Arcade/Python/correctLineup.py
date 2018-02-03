def correctLineup(athletes):
    return sum([swap(athletes[i], athletes[i+1]) for i in range(0, len(athletes), 2)], ())
def swap(a, b):
    return b, a