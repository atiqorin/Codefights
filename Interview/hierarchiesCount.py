MODULO = 1000000007


def hierarchiesCount(n, respectList):
    if(n == 1):
        return 1
    mat = [[0 for x in range(n)] for y in range(n)]
    for v in respectList:
        mat[v[0]][v[1]] = -1
        mat[v[1]][v[0]] = -1
        mat[v[0]][v[0]] += 1
        mat[v[1]][v[1]] += 1
    cof = [[0 for x in range(n - 1)] for y in range(n - 1)]
    for i in range(1, n):
        for j in range(1, n):
            cof[i - 1][j - 1] = mat[i][j]

    return (n * det(cof, n - 1)) % MODULO


def gcd(a, b):
    if(a == 0 or b == 0):
        return a + b
    return gcd(b, a % b)


def lcm(a, b):
    return a * b / gcd(a, b)


def det(mat, n):
    left = []
    for i in range(1, n):
        for j in range(i, n):
            if(mat[i][j - 1] == 0 or mat[i - 1][i - 1] == 0):
                continue
            _lcm = lcm(mat[i - 1][i - 1], mat[j][i - 1])
            rowMult = _lcm / mat[j][i - 1]
            subMult = _lcm / mat[i - 1][i - 1]
            left.insert(0, rowMult)
            for k in range(i - 1, n):
                mat[j][k] = (mat[j][k] * rowMult) - (mat[i - 1][k] * subMult)

    ans = 1
    for i in range(n):
        ans = ans * mat[i][i]
    for l in left:
        ans = ans / l
    ans %= MODULO
    if(ans < 0):
        ans += MODULO
    return ans
