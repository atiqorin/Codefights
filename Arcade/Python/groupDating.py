def groupDating(male, female):
    return [[m for m, f in zip(male, female) if m != f], [f for m, f in zip(male, female) if m != f]]
