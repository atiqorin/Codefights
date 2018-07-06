def combinationSum(a, sum):
    a.sort()
    hset = set()
    backtrack(a, sum, [], 0, hset)
    rlist = list(hset)
    if(len(rlist) == 0):
        return "Empty"
    rlist.sort()
    if(len(rlist) == 0):
        return "Empty"
    return "".join(rlist)
def backtrack(a, sum, curlist, start, result):
    if(sum == 0):
        tostr = "(" + str(curlist[0])
        for s in range(1, len(curlist)):
            tostr += " " + str(curlist[s])
        tostr += ")"
        result.add(tostr)
        return
    for i in range(start, len(a)):
        if(sum < a[i]):
            return
        backtrack(a, sum - a[i], curlist + [a[i]], i, result)
    return
