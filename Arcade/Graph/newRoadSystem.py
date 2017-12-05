def newRoadSystem(roadRegister):
    n = len(roadRegister)
    in_count = {}
    for row in range(n):
        cnt = 0
        for col in range(n):
            if roadRegister[row][col]:
                cnt += 1
        in_count[row] = cnt
    out_count = {}
    row = 0
    cnt = 0
    while row < len(roadRegister):
        col = 0
        cnt = 0
        while col < len(roadRegister):
            if roadRegister[col][row]:
                cnt += 1
            col += 1
        out_count[row] = cnt
        row += 1
    if in_count != out_count:
        return False
    return True
