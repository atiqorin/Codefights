def coolPairs(a, b):
    uniqueSums = {aa+bb for aa in a for bb in b if ((aa * bb) % (aa + bb)) == 0}
    return len(uniqueSums)
