def constructShell(n):
    return [[0]* i for i in range(1,n+1)] + list(reversed([[0]* i for i in range(1,n)]))
