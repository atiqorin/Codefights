def isTestSolvable(ids, k):
    digitSum = lambda s: sum([int(i) for i in str(s)])

    sm = 0
    for questionId in ids:
        sm += digitSum(questionId)
    return sm % k == 0
